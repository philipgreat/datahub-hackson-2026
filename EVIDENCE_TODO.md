@EVIDENCE_TODO.md 只在具备 Docker、DataHub MCP 和 TeaQL 生成环境时执行本文取证任务；每项必须有对应原始产物才能勾选。

# Runtime Evidence Collection TODO

本文只记录必须在真实运行环境中完成的取证工作。仓库中的文字和脚本一致性问题由 `EVIDENCE_FIX.md` 处理。

## 勾选规则

- `[ ]`：尚未获得可复核的原始证据。
- `[x]`：目标路径已有本次运行产生的原始记录，且内容经过复核。
- 不适用的项目写成 `N/A — <原因>`，不能为了“完成”而勾选。
- 摘要、手写成功信息、模拟输出和另一个项目的测试不能代替原始证据。
- 所有公开证据必须脱敏；不得提交 token、cookie、私有 URL、个人邮箱或无关企业元数据。

## 1. Clean Docker 环境

- [ ] 记录本次运行的 repository commit SHA 和生成前 `git status --short`。
- [ ] 记录 Docker image/tag 和不可变 digest，或 Dockerfile SHA-256。
- [ ] 记录 OS、Java、Maven、Rust、Cargo、Python、Node.js、DataHub、MCP Server、TeaQL generator 的实际版本；未使用的工具标 `N/A`。
- [ ] 记录启动 DataHub 及依赖服务的准确命令。
- [ ] 保存到 `examples/payment/run/environment.txt`，不得把 dirty worktree 描述为 clean。

## 2. DataHub 实例和数据集

- [ ] 保存真实的 `docker compose ps`/`docker inspect` 及 DataHub health endpoint 输出，替换“Mocked”状态作为验证依据。
- [ ] 运行并记录 `ingest_payment.py` 的命令、stdout/stderr 和 exit code。
- [ ] 在 DataHub 中确认 payment dataset URN、schema、description、field tags/glossary terms。
- [ ] 若关系参与模型，捕获能支持 `payment_account` 与 `user_account` 关系的 lineage、glossary、foreign-key 或 documented-join 元数据。
- [ ] 若找不到关系证据，记录查询结果为空，并保持该关系为 agent inference；不得创造 glossary term。
- [ ] 保存脱敏原始输出到 `examples/payment/run/datahub-setup.log`。
- [ ] 保存能证明关键状态的截图到 `examples/payment/screenshots/`。

## 3. External Coding Agent 与 MCP

- [ ] 记录 coding-agent 产品名和版本。
- [ ] 保存脱敏的 DataHub MCP 配置示例，包含 server command/version/transport，但不含凭据。
- [ ] 捕获 MCP `tools/list` 或等价结果，证明可用工具集合。
- [ ] 保存实际用于生成模型的用户 prompt 与 agent 指令。
- [ ] 捕获 `get_entities` 及必要的 schema/tag/glossary 查询，保留时间戳、tool name、arguments、response。
- [ ] 如果关系或 impact 影响模型，捕获 `get_lineage`；否则明确标 `N/A` 并删除相关 claims。
- [ ] 将逐次调用保存为 `examples/payment/03-mcp-tool-calls.jsonl`。
- [ ] 将本次实际上下文汇总为 `examples/payment/04-datahub-context.json`。
- [ ] 验证每个业务字段均能追溯到 MCP context；转换和忽略项写入 decision log。

## 4. 模型生成与校验

- [ ] 从本次 MCP context 重新生成唯一 canonical model：`examples/payment/05-generated-model.xml`。
- [ ] 保存 coding agent 的实际生成过程或可复核记录，不得把手工已有文件描述为本次生成。
- [ ] 运行 TeaQL model evaluation，保存 command、tool version、stdout/stderr、exit code。
- [ ] 记录最终 model SHA-256，并让 generator logs、摘要和决策文档引用同一个 hash。
- [ ] 更新 `examples/payment/06-model-decisions.md`，区分 DataHub facts、agent inferences、TeaQL framework fields。
- [ ] 做 negative check：缺失字段不得被 agent 擅自补造；保存结果。

## 5. 从空目录生成 Java 与 Rust

- [ ] 证明 Java output directory 在生成开始前为空。
- [ ] 记录 Java generation 的准确 command、版本、model path/hash、output path、开始/结束时间、stdout/stderr、exit code。
- [ ] 证明 Rust output directory 在生成开始前为空。
- [ ] 记录 Rust generation 的准确 command、版本、model path/hash、output path、开始/结束时间、stdout/stderr、exit code。
- [ ] 将最终 canonical outputs 保存到 `examples/payment/07-generated-code/`，清除重复或旧名称产物。
- [ ] 生成文件 manifest（相对路径、大小、SHA-256）；如使用 diff，应真实表示 empty-to-generated output。
- [ ] 将原始生成记录保存到 `examples/payment/run/generator.log` 及适当的细分日志。

## 6. 编译准确的生成产物

- [ ] 在 clean container 中执行并完整记录：

  ```bash
  mvn -f examples/payment/07-generated-code/java-lib-core/lib/pom.xml clean test
  cargo test --manifest-path examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml --locked -v
  ```

- [ ] Java 日志包含 command、cwd、manifest、时间戳、exit code、test count 和 duration。
- [ ] Rust 日志包含 command、cwd、manifest、crate、时间戳、exit code、test count 和 duration。
- [ ] 明确区分“编译成功但 0 tests”和“测试通过”。
- [ ] 保存完整日志到 `examples/payment/run/build-and-test/`。
- [ ] 从原始日志更新 `examples/payment/09-test-summary.md`。

## 7. Runtime policy（可选但不能冒充已完成）

- [ ] 若要声明 runtime masking，添加真实测试：读取生成 policy metadata，调用实际 TeaQL masking 行为，并断言敏感账号不可见。
- [ ] 若只证明 policy propagation，则明确范围为 `DataHub context -> TeaQL metadata -> generated metadata`，runtime masking 保持 `PENDING`。
- [ ] 若要保留 KYC runtime claim，在 Spring MVC 注册 interceptor，并用 application-context/MockMvc 测试允许和拒绝请求。
- [ ] 若要声明 lineage write-back，捕获真实 DataHub API/MCP mutation，并重新查询验证结果。
- [ ] 若不执行上述行为，删除对应 runtime/lineage claim 或标 `N/A/PENDING`。
- [ ] 更新 `examples/payment/10-context-to-code-map.md`，每条结论链接到直接证据。

## 8. 可重复性和失败行为

- [ ] 从 clean checkout 或 clean output directory 重复生成一次。
- [ ] 比较两次 file manifest/hash，记录 deterministic output 或预期 nondeterminism。
- [ ] 提供 invalid/incomplete DataHub schema，捕获 agent 的失败或澄清行为。
- [ ] 证明 agent 在缺失关键 context 时不会自行编造事实。
- [ ] 记录全流程中的人工操作、在线服务依赖和缓存假设。

## 9. 提交材料

- [ ] README 中每个阶段链接到对应原始证据，并保持 verified/pending 状态准确。
- [ ] 保存架构图和 context-to-code mapping；内容必须与本次运行一致。
- [ ] 录制三分钟以内的公开 demo，展示 live MCP call、模型、生成代码和准确的 build/test。
- [ ] 将公开视频链接加入 README 和 Devpost。
- [ ] 披露 hackathon 前已有的 TeaQL 组件，以及本次新增的 workflow/code。
- [ ] 确认公开仓库和 Apache 2.0 license 可见。
- [ ] 执行 secret/PII scan 并保存命令与结果。

## 最终验收

- [ ] 所有 `[x]` 项均能指向原始证据文件及其中的准确位置。
- [ ] MCP JSONL、context JSON、model、generator log 和 generated outputs 使用同一轮运行信息。
- [ ] Java/Rust 构建针对最终 payment outputs，而非根目录 ERP 示例或父目录项目。
- [ ] relationship 来自 DataHub 的证据已捕获；否则清楚标为 agent inference。
- [ ] runtime masking、KYC、data quality 和 lineage 没有相互替代证明。
- [ ] README 没有把手工多阶段流程称为一条自动 end-to-end command。
- [ ] 最终 commit、model hash、timestamps、commands 和 exit codes 在各文档中一致。
