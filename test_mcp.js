const { spawn } = require('child_process');

const mcp = spawn('python3', ['-m', 'mcp_server_datahub'], {
  env: { ...process.env, DATAHUB_GMS_URL: 'http://localhost:8080' }
});

let output = '';

mcp.stdout.on('data', (data) => {
  output += data.toString();
  // We expect JSON-RPC responses.
  // After getting response for id:1, we can parse it and call the schema tool.
  try {
    const lines = output.split('\n');
    for (const line of lines) {
      if (!line.trim()) continue;
      const parsed = JSON.parse(line);
      if (parsed.id === 1) {
        console.log("=== MCP Tools Available ===");
        const tools = parsed.result.tools.map(t => t.name);
        console.log(tools);
        
        // Now let's call the schema tool for the payment_transactions table!
        const callSchema = {
          jsonrpc: "2.0",
          id: 2,
          method: "tools/call",
          params: {
            name: "list_schema_fields", // usually get_schema or get_dataset_schema
            arguments: {
              urn: "urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)"
            }
          }
        };
        mcp.stdin.write(JSON.stringify(callSchema) + '\n');
      } else if (parsed.id === 2) {
        console.log("\n=== MCP Schema Response ===");
        console.log(JSON.stringify(parsed.result, null, 2));
        mcp.kill();
        process.exit(0);
      }
    }
    output = ''; // clear processed
  } catch (e) {
    // wait for more data
  }
});

mcp.stderr.on('data', (data) => {
  // MCP servers usually log to stderr
  console.error(`[MCP LOG] ${data}`);
});

// Send initialization request
const initReq = {
  jsonrpc: "2.0",
  id: 0,
  method: "initialize",
  params: {
    protocolVersion: "2024-11-05",
    capabilities: {},
    clientInfo: { name: "antigravity-test", version: "1.0.0" }
  }
};
mcp.stdin.write(JSON.stringify(initReq) + '\n');

// Then send tools/list
const listTools = {
  jsonrpc: "2.0",
  id: 1,
  method: "tools/list"
};
mcp.stdin.write(JSON.stringify(listTools) + '\n');

setTimeout(() => {
  console.log("Timeout waiting for MCP.");
  mcp.kill();
  process.exit(1);
}, 8000);
