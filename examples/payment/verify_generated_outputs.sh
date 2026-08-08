#!/usr/bin/env bash

set -u

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
JAVA_HOME_PATH="/home/philip/.sdkman/candidates/java/25.0.2-graalce"
MAVEN_PATH="/home/philip/.sdkman/candidates/maven/current/bin/mvn"
CARGO_PATH="/home/philip/.cargo/bin/cargo"

run_java() {
  local manifest="examples/payment/07-generated-code/java-lib-core/lib/pom.xml"
  echo "TARGET=payment-service-java-library"
  echo "CWD=$WORKSPACE"
  echo "MANIFEST=$manifest"
  echo "COMMAND=TEAQL_TRACE_MODE=off TEAQL_TRACE_OFF_ACK=<acknowledged-value> mvn -f $manifest clean test"
  cd "$WORKSPACE"
  JAVA_HOME="$JAVA_HOME_PATH" \
    TEAQL_TRACE_MODE=off \
    TEAQL_TRACE_OFF_ACK=__i_agree_to_disable_runtime_trace_only_for_extreme_performance_testing \
    PATH="$JAVA_HOME_PATH/bin:/home/philip/.sdkman/candidates/maven/current/bin:/usr/bin:/bin" \
    "$MAVEN_PATH" -f "$manifest" clean test
}

run_rust() {
  local manifest="examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml"
  echo "TARGET=payment-service-rust-library"
  echo "CWD=$WORKSPACE"
  echo "MANIFEST=$manifest"
  echo "COMMAND=TEAQL_AUDIT_LOG=_silent cargo test --manifest-path $manifest --locked --offline -- --nocapture"
  cd "$WORKSPACE"
  TEAQL_AUDIT_LOG=_silent "$CARGO_PATH" test \
    --manifest-path "$manifest" \
    --locked \
    --offline \
    -- \
    --nocapture
}

started_epoch="$(date +%s)"
echo "STARTED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"

set +e
case "${1:-}" in
  java)
    run_java
    exit_code=$?
    ;;
  rust)
    run_rust
    exit_code=$?
    ;;
  *)
    echo "usage: $0 {java|rust}" >&2
    exit 2
    ;;
esac
set -e

finished_epoch="$(date +%s)"
echo "FINISHED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "DURATION_SECONDS=$((finished_epoch - started_epoch))"
echo "EXIT_CODE=$exit_code"
exit "$exit_code"
