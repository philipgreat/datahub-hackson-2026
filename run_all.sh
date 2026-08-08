#!/usr/bin/env bash

set -u

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
LOG_DIR="$WORKSPACE/examples/payment/run/build-and-test"
BUILD_LOG="$LOG_DIR/run_all.log"
mkdir -p "$LOG_DIR"
: > "$BUILD_LOG"

failures=0
skipped=0

log() {
  printf '%s\n' "$1" | tee -a "$BUILD_LOG"
}

run_target() {
  local kind="$1"
  local name="$2"
  local relative_manifest="$3"
  local manifest="$WORKSPACE/$relative_manifest"
  local started_at
  local finished_at
  local start_epoch
  local end_epoch
  local exit_code
  local cargo_lock

  log "======================================="
  log "Target: $name"
  log "Working directory: $WORKSPACE"
  log "Manifest: $relative_manifest"

  if [[ ! -f "$manifest" ]]; then
    log "Status: SKIPPED (manifest not found)"
    skipped=$((skipped + 1))
    return
  fi

  started_at="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  start_epoch="$(date +%s)"
  log "Started: $started_at"

  if [[ "$kind" == "maven" ]]; then
    log "Command: mvn -f $relative_manifest clean test"
    mvn -f "$manifest" clean test >> "$BUILD_LOG" 2>&1
    exit_code=$?
  else
    cargo_lock="${manifest%Cargo.toml}Cargo.lock"
    if [[ -f "$cargo_lock" ]]; then
      log "Command: cargo test --manifest-path $relative_manifest --locked"
      cargo test --manifest-path "$manifest" --locked >> "$BUILD_LOG" 2>&1
      exit_code=$?
    else
      log "Command: cargo test --manifest-path $relative_manifest"
      log "Lockfile: not present; running without --locked"
      cargo test --manifest-path "$manifest" >> "$BUILD_LOG" 2>&1
      exit_code=$?
    fi
  fi

  end_epoch="$(date +%s)"
  finished_at="$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  log "Finished: $finished_at"
  log "Duration seconds: $((end_epoch - start_epoch))"
  log "Exit code: $exit_code"

  if [[ "$exit_code" -eq 0 ]]; then
    log "Status: PASSED (inspect tool output for the test count; zero tests means compilation only)"
  else
    log "Status: FAILED"
    failures=$((failures + 1))
  fi
}

run_target maven erp-java-lib-core java-lib-core/pom.xml
run_target maven erp-java-spring-boot java-web-spring-boot/pom.xml
run_target maven erp-java-quarkus java-web-quarkus/pom.xml
run_target maven erp-java-micronaut java-web-micronaut/pom.xml
run_target cargo erp-rust-lib-core rust-lib-core/Cargo.toml
run_target cargo erp-rust-console rust-app-console/Cargo.toml
run_target cargo erp-rust-axum rust-web-axum/Cargo.toml
run_target cargo erp-rust-topcoat-library rust-web-topcoat/lib/Cargo.toml
run_target maven payment-service-java-library examples/payment/07-generated-code/java-lib-core/lib/pom.xml
run_target cargo payment-service-rust-library examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml

log "======================================="
log "Failed targets: $failures"
log "Skipped targets: $skipped"

if [[ "$failures" -ne 0 ]]; then
  exit 1
fi
