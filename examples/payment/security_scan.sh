#!/usr/bin/env bash

set -u

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$WORKSPACE"

echo "STARTED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "SCOPE=authored documentation, MCP/context evidence, scripts, and text logs"

failures=0

check_absent() {
  local label="$1"
  local pattern="$2"
  shift 2
  if rg -n -i "$pattern" "$@"; then
    echo "RESULT=$label FAIL"
    failures=$((failures + 1))
  else
    echo "RESULT=$label PASS"
  fi
}

scan_paths=(
  README.md
  EVIDENCE.md
  EVIDENCE_TODO.md
  mcp_client.py
  examples/payment/01-user-request.md
  examples/payment/02-mcp-config.example.json
  examples/payment/03-mcp-tool-calls.jsonl
  examples/payment/04-datahub-context.json
  examples/payment/05-generated-model.xml
  examples/payment/06-model-decisions.md
  examples/payment/09-test-summary.md
  examples/payment/10-context-to-code-map.md
  examples/payment/run
)

check_absent "known_sample_pii" \
  'jdoe@linkedin\.com|John Doe|urn:li:corpuser:jdoe' \
  "${scan_paths[@]}"
check_absent "authorization_or_bearer" \
  'authorization:|bearer [A-Za-z0-9._-]{16,}' \
  "${scan_paths[@]}"
check_absent "unmasked_api_key_or_password" \
  'api[_-]?key.{0,8}[=:].{0,4}[A-Za-z0-9._-]{12,}|password.{0,8}[=:].{0,4}[^* <][^ <]{7,}' \
  "${scan_paths[@]}"
check_absent "synthetic_raw_account_in_logs" \
  'TEST-ACCOUNT-0001' \
  examples/payment/run

echo "FINISHED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "FAILURES=$failures"
if [[ "$failures" -eq 0 ]]; then
  echo "SECURITY_SCAN=PASS"
else
  echo "SECURITY_SCAN=FAIL"
fi
exit "$failures"
