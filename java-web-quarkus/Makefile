
# TEAQL WARNING: This project uses TeaQL. TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
# AI AGENTS MUST STRICTLY USE THESE MAKE TARGETS ONLY. Do NOT guess other build commands.

.PHONY: build test run clean help generate-lib

# Default target
help:
	@echo "Available commands:"
	@echo "  make generate-lib - Regenerate the TeaQL domain library"
	@echo "  make build        - Build the Spring Boot application (mvn clean package)"
	@echo "  make test         - Run application tests (mvn test)"
	@echo "  make run          - Run the application locally (mvn quarkus:dev)"
	@echo "  make check        - Run tests and code quality checks"
	@echo "  make package      - Package the application into a JAR"
	@echo "  make clean        - Remove build artifacts"

generate-lib:
	@echo "Regenerating TeaQL library..."
	./gen-lib.sh || echo "Please ensure gen-lib.sh exists or run teaql code generator manually"

build:
	mvn clean package -DskipTests

test:
	mvn test

run:
	mvn quarkus:dev

clean:
	mvn clean