#!/usr/bin/env bash

set -u

WORKSPACE="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
JAVA_HOME_PATH="/home/philip/.sdkman/candidates/java/25.0.2-graalce"
MAVEN_PATH="/home/philip/.sdkman/candidates/maven/current/bin/mvn"
CARGO_PATH="/home/philip/.cargo/bin/cargo"
RUSTC_PATH="/home/philip/.cargo/bin/rustc"

environment_evidence() {
  echo "CAPTURED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "WORKSPACE=<workspace>"
  echo "GIT_COMMIT=$(git -C "$WORKSPACE" rev-parse HEAD)"
  echo "GIT_STATUS_BEGIN"
  git -C "$WORKSPACE" status --short
  echo "GIT_STATUS_END"
  uname -a
  cat /etc/os-release
  "$JAVA_HOME_PATH/bin/java" -version 2>&1
  JAVA_HOME="$JAVA_HOME_PATH" "$MAVEN_PATH" -version
  "$RUSTC_PATH" --version
  "$CARGO_PATH" --version
  "$CARGO_PATH" teaql --version
  python3 --version
  if command -v node >/dev/null 2>&1; then
    node --version
  else
    echo "Node.js: NOT INSTALLED"
  fi
  python3 -m pip show mcp-server-datahub | sed -n '1,8p'
  echo "TEAQL_GENERATOR_ENDPOINT=http://127.0.0.1:18080/"
  curl -fsS http://127.0.0.1:18080/version
  echo "DATAHUB_GMS_IMAGE_ID=$(docker inspect --format '{{.Image}}' datahub-datahub-gms-quickstart-1)"
  docker image inspect acryldata/datahub-gms:v1.5.0.6 \
    --format 'DATAHUB_GMS_REPO_DIGEST={{index .RepoDigests 0}}'
}

datahub_evidence() {
  echo "CAPTURED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
  echo "COMMAND=docker ps --filter name=datahub"
  docker ps --filter name=datahub \
    --format '{{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}'
  echo "COMMAND=docker inspect datahub-datahub-gms-quickstart-1"
  docker inspect --format '{{json .State.Health}}' datahub-datahub-gms-quickstart-1
  echo "COMMAND=curl http://localhost:8080/health"
  curl -sS -o /dev/null -w 'HTTP_STATUS=%{http_code}\n' http://localhost:8080/health
  echo "COMMAND=python3 ingest_payment.py"
  cd "$WORKSPACE"
  python3 ingest_payment.py
}

case "${1:-}" in
  environment)
    environment_evidence
    ;;
  datahub)
    datahub_evidence
    ;;
  *)
    echo "usage: $0 {environment|datahub}" >&2
    exit 2
    ;;
esac
