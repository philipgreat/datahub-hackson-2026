import subprocess
import json
import time
import sys

def call_mcp(tool_name, arguments):
    process = subprocess.Popen(
        ['python3', '-m', 'mcp_server_datahub'],
        env={"DATAHUB_GMS_URL": "http://localhost:8080"},
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )
    
    # Send init
    init_req = json.dumps({
        "jsonrpc": "2.0", "id": 0, "method": "initialize",
        "params": {"protocolVersion": "2024-11-05", "capabilities": {}, "clientInfo": {"name": "client", "version": "1.0"}}
    }) + "\n"
    process.stdin.write(init_req)
    process.stdin.flush()
    
    # Send tool call
    call_req = json.dumps({
        "jsonrpc": "2.0", "id": 1, "method": "tools/call",
        "params": {"name": tool_name, "arguments": arguments}
    }) + "\n"
    process.stdin.write(call_req)
    process.stdin.flush()
    
    output = ""
    while True:
        line = process.stdout.readline()
        if not line:
            break
        if not line.strip():
            continue
        try:
            resp = json.loads(line)
            if resp.get("id") == 1:
                return resp.get("result")
        except json.JSONDecodeError:
            pass

if __name__ == "__main__":
    tool = sys.argv[1]
    urn = sys.argv[2]
    if tool == "get_entities":
        args = {"urns": [urn]}
    else:
        args = {"urn": urn}
    res = call_mcp(tool, args)
    print(json.dumps(res, indent=2))
