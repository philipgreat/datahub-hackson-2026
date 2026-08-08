#!/usr/bin/env bash

set -u

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
MODEL="$WORKSPACE/examples/payment/05-generated-model.xml"
JAVA_EXPECTED="$WORKSPACE/examples/payment/07-generated-code/java-lib-core"
RUST_EXPECTED="$WORKSPACE/examples/payment/07-generated-code/rust-lib-core"
MAVEN_PATH="/home/philip/.sdkman/candidates/maven/current/bin/mvn"
CARGO_PATH="/home/philip/.cargo/bin/cargo"
ENDPOINT="http://127.0.0.1:18080/"
REPEAT_ROOT="$(mktemp -d /tmp/payment-repeat.XXXXXX)"

echo "STARTED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "MODEL_SHA256=$(sha256sum "$MODEL" | cut -d' ' -f1)"
echo "REPEAT_OUTPUT_ROOT=$REPEAT_ROOT"
echo "EMPTY_ENTRY_COUNT=$(find "$REPEAT_ROOT" -mindepth 1 -maxdepth 1 | wc -l)"

echo "COMMAND=TEAQL_ENDPOINT_PREFIX=$ENDPOINT mvn teaql:generate -Dservice=java-lib-core"
TEAQL_ENDPOINT_PREFIX="$ENDPOINT" "$MAVEN_PATH" \
  io.teaql:teaql-maven-plugin:1.1.0:generate \
  -Dservice=java-lib-core \
  -Dinput="$MODEL" \
  -Dteaql.output="$REPEAT_ROOT/java-lib-core"

echo "COMMAND=cargo teaql --endpoint-prefix $ENDPOINT --input <model> --output <repeat>/rust-lib-core rust-lib-core"
"$CARGO_PATH" teaql \
  --endpoint-prefix "$ENDPOINT" \
  --input "$MODEL" \
  --output "$REPEAT_ROOT/rust-lib-core" \
  rust-lib-core

echo "JAVA_COMPARISON=exclude domain.zip,target"
diff -qr --exclude=domain.zip --exclude=target \
  "$JAVA_EXPECTED" "$REPEAT_ROOT/java-lib-core"

echo "RUST_COMPARISON=exclude domain.zip,Cargo.lock,tests,target"
diff -qr --exclude=domain.zip --exclude=Cargo.lock --exclude=tests --exclude=target \
  "$RUST_EXPECTED" "$REPEAT_ROOT/rust-lib-core"

echo "DETERMINISTIC_GENERATED_SOURCES=true"
echo "FINISHED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
