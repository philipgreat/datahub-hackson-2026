#!/usr/bin/env bash

set -u

DATAHUB_CLI=/home/philip/.local/bin/datahub
COMPOSE_CLI=/usr/local/bin/docker-compose
COMPOSE_FILE=/home/philip/.datahub/quickstart/docker-compose.yml
SHELL_HISTORY=/home/philip/.bash_history

echo "STARTED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
echo "EVIDENCE_HOST=$(hostname)"

echo "COMMAND=$DATAHUB_CLI version"
"$DATAHUB_CLI" version

echo "COMMAND=rg -n '^datahub docker quickstart$' $SHELL_HISTORY"
rg -n '^datahub docker quickstart$' "$SHELL_HISTORY"

echo "VERIFIED_START_COMMAND=datahub docker quickstart"
echo "COMMAND=$DATAHUB_CLI docker quickstart --help"
"$DATAHUB_CLI" docker quickstart --help

echo "COMMAND=$COMPOSE_CLI version"
"$COMPOSE_CLI" version
echo "COMPOSE_FILE=$COMPOSE_FILE"
echo "COMPOSE_FILE_SHA256=$(sha256sum "$COMPOSE_FILE" | cut -d' ' -f1)"

echo "COMMAND=docker ps --filter label=com.docker.compose.project=datahub"
docker ps \
  --filter label=com.docker.compose.project=datahub \
  --format '{{.Names}}\t{{.Image}}\t{{.Status}}' \
  | sort

echo "COMMAND=docker inspect <active-datahub-container> compose labels"
while IFS= read -r container; do
  docker inspect "$container" --format \
    'CONTAINER={{.Name}} PROJECT={{index .Config.Labels "com.docker.compose.project"}} SERVICE={{index .Config.Labels "com.docker.compose.service"}} CONFIG={{index .Config.Labels "com.docker.compose.project.config_files"}} WORKDIR={{index .Config.Labels "com.docker.compose.project.working_dir"}} COMPOSE_VERSION={{index .Config.Labels "com.docker.compose.version"}}'
done < <(docker ps \
  --filter label=com.docker.compose.project=datahub \
  --format '{{.Names}}' \
  | sort)

echo "COMMAND=curl -fsS -o /dev/null -w HTTP_STATUS=<status> http://localhost:8080/health"
curl -fsS -o /dev/null -w 'HTTP_STATUS=%{http_code}\n' http://localhost:8080/health
echo "FINISHED_AT_UTC=$(date -u +%Y-%m-%dT%H:%M:%SZ)"
