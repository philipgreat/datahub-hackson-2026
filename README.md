# datahub-hackson-2026

## 项目定位

本项目基于 Payment 模型，通过不同的 Workspace 处理不同的任务。

## 模块分工

- **Rust APP Console**：用于流式数据处理。通过 `execute for stream` 读取数据流以进行批量化处理。
- **Web 框架 Action**：用于处理主流程，包括执行配置动作和 Payment 动作。
- **Java 模块**：用于管理客户资料变更等关联业务。

## 数据存储与运行环境

- **数据库**：使用 PostgreSQL 作为底层共享数据库，供所有的 Java 和 Rust 工作区使用。
- **缓存**：使用 Redis。
- **部署方式**：PostgreSQL 和 Redis 均通过 Docker 进行本地启动和管理。

## 仓库结构与测试导航

以下表格列出了本仓库中的主要工作区 (Workspace)、核心脚本及其对应的测试用例位置：

| 目录 / 文件 | 类型 | 内容说明 | 单元测试 / 集成测试位置 |
| --- | --- | --- | --- |
| `java-web-spring-boot` | Workspace | 基于 Spring Boot 的 Java Web 服务，处理客户资料变更与 KYC 准入控制切面。 | `src/test/java/.../KycAuthInterceptorTest.java` |
| `java-web-quarkus` | Workspace | 基于 Quarkus 的 Java Web 服务 (由模型自动生成)。 | 自动生成用例集成于 `mvn test` 阶段 |
| `java-web-micronaut` | Workspace | 基于 Micronaut 的 Java Web 服务 (由模型自动生成)。 | 自动生成用例集成于 `mvn test` 阶段 |
| `java-lib-core` | Workspace | Java 领域核心底层库 (由模型自动生成)。 | 建议 Code Review 时忽略 |
| `rust-app-console` | Workspace | Rust 控制台流处理应用，负责数据质量过滤与血缘上报。 | `src/main.rs` 中的 `tests::test_process_stream_data_quality` |
| `rust-web-axum` | Workspace | Rust Web 框架服务，负责执行配置与 Payment 核心动作及 Redis 限流。 | 包含在 `cargo test` 中运行 |
| `rust-web-topcoat` | Workspace | Rust Web 备选框架服务 (由模型自动生成)。 | 包含在 `cargo test` 中运行 |
| `rust-lib-core` | Workspace | Rust 领域核心底层库 (由模型自动生成)。 | 建议 Code Review 时忽略 |
| `mock_datahub_agent.py` | Script | 演示 DataHub Agent 提取元数据、合规标签并动态生成 TeaQL 的核心逻辑脚本。 | `test_business_enrichment.py` (集成测试) |
| `run_all.sh` | Script | 一键触发所有工作区代码编译与测试验证的脚本。 | 无 |
| `docker-compose.yml` | Config | 本地快速拉起 PostgreSQL (5433) 与 Redis (6380) 测试环境的配置。 | 无 |

## Code Review 指引

本项目包含大量由 AI Agent 基于 DataHub 元数据自动生成的基础设施代码（总计逾 27 万行）。为了提高审查效率，建议评委重点关注应用层实现。

### 重点审查模块

- **Rust 应用工作区**：
  - `rust-web-axum` / `rust-web-topcoat`：包含 Web 主流程，负责配置动作和 Payment 动作。
  - `rust-app-console`：使用 `execute for stream` 读取流数据并进行批量化处理。
- **Java 应用工作区**：
  - `java-web-spring-boot` 等：处理客户资料变更等关联业务。
- **Agent 与集成逻辑**：
  - 根目录 Python 脚本（如 `agent_datahub_to_teaql.py`）：演示调用 DataHub MCP 获取数据结构、解析 PII 标签并生成 TeaQL 模型的完整流程。

### 建议忽略的模块

以下核心领域库完全由引擎自动生成，包含大量底层安全机制与类型校验，建议在审查时跳过：
- `rust-lib-core`
- `java-lib-core`