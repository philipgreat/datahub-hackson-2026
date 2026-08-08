#!/usr/bin/env bash

set -euo pipefail

if [[ "$#" -ne 1 ]]; then
  echo "usage: $0 <agy-stream-json-log>" >&2
  exit 2
fi

result_line="$(rg -N '^\{"event":"result"' "$1" | tail -n 1)"
structured_output="$(jq -c '.result.structured_output' <<<"$result_line")"

jq -e '
  .decision == "REFUSE_MISSING_CONTEXT" and
  .can_generate == false and
  .mcp_tool == "get_entities" and
  (.mcp_result | contains("not found")) and
  .generated_business_fields == [] and
  .generated_relations == [] and
  (.clarification_request | length > 0)
' <<<"$structured_output" >/dev/null

echo "$structured_output" | jq -M .
echo "NEGATIVE_AGENT_ASSERTIONS=PASS"
