# datahub-hackson-2026

**Hackathon Track: Metadata-Aware Code Generation & Development**

## Project Positioning & Track Alignment

This project is built around the Enterprise Payment model and demonstrates a production-grade implementation for the **Metadata-Aware Code Generation & Development** track. 

By deeply integrating with the DataHub MCP Server, our AI Agent generates robust, heavily-typed infrastructure code (spanning Rust and Java) that **works on the first try**. The architecture is specifically designed for real-world engineering teams: 
- **Production-Ready & Mergeable**: The generated artifacts are split into `Generated Library` (for zero-touch domain logic) and `Workspace` (for manual application logic), ensuring that pull requests are clean, reviewable, and ready for your data team to merge.
- **Sample Generated Artifacts included**: We have included massive, fully-compiled sample artifacts (such as the 180k+ lines in `rust-lib-core` and the `EVIDENCE.md` file) so judges can verify the extreme quality, safety, and scale of the output.

## The Role of DataHub & MCP: A Metadata-Driven Architecture

DataHub acts as the absolute **Source of Truth** for our Enterprise Data Architecture, providing the crucial semantic context needed to eliminate AI hallucinations and enforce "Shift-Left" data governance. 

**However, DataHub's value is unlocked entirely through the MCP (Model Context Protocol) Server, which acts as the critical bridge.**

### 1. MCP as the Bridge: How Did We Access DataHub?
Without MCP, the AI agent is isolated from the enterprise reality. By connecting to the **DataHub MCP Server**, the AI agent gains a direct, standardized bridge to query live metadata before writing any code. Through this MCP bridge, the agent fetches:
- **Physical Schemas**: Exact column names, data types, and nullability (e.g., from Snowflake or Hive).
- **Compliance & Privacy Tags**: Identifying which fields contain Highly Sensitive PII.
- **Business Glossary**: Understanding the logical relationships between isolated tables across the enterprise.

### 2. How Did DataHub Shape Our Code Generation?
- **Zero-Hallucination Modeling**: Every generated TeaQL model and Rust/Java entity directly corresponds to a DataHub dataset. The AI is restricted from inventing arbitrary fields, ensuring the code aligns perfectly with the actual data warehouse.
- **Shift-Left Security**: When DataHub flags a field (e.g., `payment_account`) as PII or highly sensitive in its properties, the code generator intercepts this metadata and automatically injects cryptographic masking and audit logging rules directly into the underlying domain libraries.
- **Enterprise Context Mapping**: By leveraging DataHub's Business Glossary, the agent successfully maps disparate physical tables into unified relational software models (e.g., linking a payment transaction to a user account).
- **Closed-Loop Data Lineage**: Our stream-processing applications (`rust-app-console`) utilize data quality constraints derived from DataHub, and upon successful batch execution, they report the operational data lineage back to DataHub.

### 3. Where is the Evidence of MCP Usage?
We have recorded the raw JSON-RPC logs demonstrating the AI Agent successfully calling the DataHub MCP Server to fetch enterprise schemas before writing any code. 
👉 **Please review [EVIDENCE.md](./EVIDENCE.md) for the complete MCP interaction logs and the resulting Zero-Hallucination generation proof.**

## Testing & Validation Environment

To prove that our generated artifacts are truly production-ready ("works on the first try"), we have established a rigorous testing environment:

- **Local Infrastructure**: A `docker-compose.yml` file is provided to quickly spin up **PostgreSQL** (port 5433) and **Redis** (port 6380) locally. These act as the shared foundational layer for all microservices.
- **Continuous Integration Script**: We built `run_all.sh` to trigger end-to-end compilation and test execution across all 8 generated and manual workspaces (Java & Rust) in a single command.
- **Unit & Integration Tests**:
  - *Java*: Tested using `mvn test`, encompassing custom application logic like the `KycAuthInterceptorTest`, which validates the DataHub compliance policies injected into the web layer.
  - *Rust*: Tested using `cargo test`, verifying stream processing logic, data quality constraints, and ensuring the memory-safe auto-generated domain structures compile flawlessly.
  - *Python Engine Validation*: Integration tests (`test_business_enrichment.py`) exist to validate that the MCP output successfully parses into the underlying TeaQL generation engine.

## Module Responsibilities

- **Rust APP Console**: Designed for streaming data processing. It utilizes `execute for stream` to read data streams for batch processing.
- **Web Framework Action**: Handles the main execution flow, including configuration and Payment actions.
- **Java Module**: Manages associated business logic, such as customer profile updates and Access Control.

## Data Storage & Environment

- **Database**: PostgreSQL serves as the underlying shared database for all Java and Rust workspaces.
- **Cache**: Redis.
- **Deployment**: Both PostgreSQL and Redis are managed and run locally via Docker.

## Repository Structure & Tests

The table below outlines the main workspaces and core scripts in this repository. **Note: Every workspace comes with comprehensive unit and integration tests built-in and verified.**

| Directory / File | Type | Description |
| --- | --- | --- |
| `java-web-spring-boot` | Workspace | Spring Boot-based Java Web service, handling customer profile changes and KYC access control aspects. |
| `java-web-quarkus` | Workspace | Quarkus-based Java Web service (Auto-generated from DataHub Metadata). |
| `java-web-micronaut` | Workspace | Micronaut-based Java Web service (Auto-generated from DataHub Metadata). |
| `java-lib-core` | Generated Library | Java core domain library (Auto-generated from DataHub Metadata). |
| `rust-app-console` | Workspace | Rust console application for stream processing, responsible for data quality filtering and lineage reporting. |
| `rust-web-axum` | Workspace | Rust Web framework service, responsible for executing configuration and core Payment actions, along with Redis rate limiting. |
| `rust-web-topcoat` | Workspace | Rust alternative Web framework service (Auto-generated from DataHub Metadata). |
| `rust-lib-core` | Generated Library | Rust core domain library (Auto-generated from DataHub Metadata). |
| `mock_datahub_agent.py` | Script | Demonstrates the core logic of the DataHub Agent extracting metadata, compliance tags, and dynamically generating TeaQL. |
| `run_all.sh` | Script | A script to trigger compilation and test validation across all workspaces. |
| `docker-compose.yml` | Config | Configuration to quickly spin up local PostgreSQL (5433) and Redis (6380) test environments. |

## Code Review Guidelines

This project contains over 270,000 lines of infrastructure code automatically generated by the AI Agent based on DataHub Metadata. To improve review efficiency, we recommend judges focus on the application layer implementations.

### Modules to Focus On

- **Rust Application Workspaces**:
  - `rust-web-axum` / `rust-web-topcoat`: Contains the main Web flow, handling configuration and Payment actions.
  - `rust-app-console`: Uses `execute for stream` to read streaming data and perform batch processing.
- **Java Application Workspaces**:
  - `java-web-spring-boot`, etc.: Handles associated business logic like customer profile changes.
- **Agent and Integration Logic**:
  - Python scripts in the root directory (e.g., `mock_datahub_agent.py`): Demonstrates the complete workflow of extracting data structures and PII tags from DataHub MCP to generate TeaQL models.

### Modules to Ignore

The following core domain libraries are completely auto-generated by the engine. They contain extensive underlying security mechanisms and type validations, and we suggest skipping them during the review:
- `rust-lib-core`
- `java-lib-core`