#!/usr/bin/env python3

import argparse
import datetime
import json
import os
import subprocess
import sys


def request(method, params=None):
    env = os.environ.copy()
    env.setdefault("DATAHUB_GMS_URL", "http://localhost:8080")
    process = subprocess.Popen(
        [sys.executable, "-m", "mcp_server_datahub"],
        env=env,
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True,
    )
    try:
        messages = [
            {
                "jsonrpc": "2.0",
                "id": 0,
                "method": "initialize",
                "params": {
                    "protocolVersion": "2024-11-05",
                    "capabilities": {},
                    "clientInfo": {"name": "evidence-client", "version": "1.0"},
                },
            },
            {"jsonrpc": "2.0", "method": "notifications/initialized"},
            {"jsonrpc": "2.0", "id": 1, "method": method, "params": params or {}},
        ]
        for message in messages:
            process.stdin.write(json.dumps(message) + "\n")
        process.stdin.flush()

        for line in process.stdout:
            if not line.strip():
                continue
            response = json.loads(line)
            if response.get("id") == 1:
                if "error" in response:
                    raise RuntimeError(json.dumps(response["error"], ensure_ascii=False))
                return response.get("result")
        stderr = process.stderr.read()
        raise RuntimeError(f"MCP server exited without a response: {stderr}")
    finally:
        process.terminate()
        try:
            process.wait(timeout=5)
        except subprocess.TimeoutExpired:
            process.kill()


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("tool", choices=["list_tools", "get_entities", "get_lineage"])
    parser.add_argument("urns", nargs="*")
    parser.add_argument("--jsonl", action="store_true")
    args = parser.parse_args()

    if args.tool == "list_tools":
        method = "tools/list"
        arguments = {}
        result = request(method)
    elif args.tool == "get_entities":
        if not args.urns:
            parser.error("get_entities requires at least one URN")
        method = "tools/call"
        arguments = {"urns": args.urns}
        result = request(method, {"name": args.tool, "arguments": arguments})
    else:
        if len(args.urns) != 1:
            parser.error("get_lineage requires exactly one URN")
        method = "tools/call"
        arguments = {"urn": args.urns[0]}
        result = request(method, {"name": args.tool, "arguments": arguments})

    if args.jsonl:
        record = {
            "timestamp": datetime.datetime.now(datetime.timezone.utc).isoformat(),
            "tool": args.tool,
            "arguments": arguments,
            "result": result,
        }
        print(json.dumps(record, ensure_ascii=False, separators=(",", ":")))
    else:
        print(json.dumps(result, ensure_ascii=False, indent=2))


if __name__ == "__main__":
    main()
