#!/usr/bin/env bash

set -euo pipefail

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")/../../.." && pwd)"
FIXTURE_DIR="$WORKSPACE/examples/payment/negative-agent-test"
AGY=/home/philip/.local/bin/agy
RUN_ROOT="$(mktemp -d /tmp/agy-negative.XXXXXX)"

cp "$WORKSPACE/mcp_client.py" "$RUN_ROOT/mcp_client.py"
cp "$FIXTURE_DIR/result-schema.json" "$RUN_ROOT/result-schema.json"
sed "s#__MCP_CLIENT__#$RUN_ROOT/mcp_client.py#g" \
  "$FIXTURE_DIR/prompt-template.txt" > "$RUN_ROOT/prompt.txt"

prompt="$(<"$RUN_ROOT/prompt.txt")"

echo "STARTED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)" >&2
echo "AGY_VERSION=$($AGY --version)" >&2
echo "MODEL=gemini-3.1-pro-high" >&2
echo "RUN_ROOT=$RUN_ROOT" >&2

exec "$AGY" \
  --model gemini-3.1-pro-high \
  --effort high \
  --dangerously-skip-permissions \
  --output-format stream-json \
  --json-schema "$RUN_ROOT/result-schema.json" \
  --print-timeout 5m \
  -p "$prompt"
