@EVIDENCE_TODO.md 只在具备 Docker、DataHub MCP 和 TeaQL 生成环境时执行本文取证任务；每项必须有对应原始产物才能勾选。

# Runtime Evidence Collection TODO

本文只记录必须在真实运行环境中完成的取证工作。仓库中的文字和脚本一致性问题由 `EVIDENCE_FIX.md` 处理。

## 勾选规则

- `[ ]`：尚未获得可复核的原始证据。
- `[x]`：目标路径已有本次运行产生的原始记录，且内容经过复核。
- 不适用的项目写成 `N/A — <原因>`，不能为了“完成”而勾选。
- 摘要、手写成功信息、模拟输出和另一个项目的测试不能代替原始证据。
- 所有公开证据必须脱敏；不得提交 token、cookie、私有 URL、个人邮箱或无关企业元数据。

## 1. Evidence Host 环境

- [x] 记录本次运行的 repository commit SHA 和 `git status --short`；本次取证时 worktree 为 dirty，未声称 clean。
- [x] 记录 DataHub Docker image/tag、image ID 和不可变 digest。
- [x] 记录 OS、Java、Maven、Rust、Cargo、Python、DataHub、MCP Server、TeaQL generator 的实际版本；Node.js 明确记录为未安装。
- [ ] 记录启动 DataHub 及依赖服务的准确命令。
- [x] 保存到 `examples/payment/run/environment.txt`，且没有把 dirty worktree 描述为 clean。

## 2. DataHub 实例和数据集

- [x] 保存真实的 `docker ps`、`docker inspect` 及 DataHub health endpoint 输出，替换“Mocked”状态作为验证依据。
- [x] 运行并记录 `ingest_payment.py` 的命令、stdout/stderr 和 exit code。
- [x] 在 DataHub 中确认 payment dataset URN、schema、description，以及返回的空 field tags。
- [x] 捕获 payment dataset 的 `get_lineage`；结果 upstream total 为 `0`，没有关系依据。
- [x] 因找不到关系证据，删除 `payment_account -> user_account` 推断关系，不创造 glossary term。
- [x] 保存脱敏原始输出到 `examples/payment/run/datahub-setup.log`。
- [ ] 保存能证明关键状态的截图到 `examples/payment/screenshots/`。

## 3. External Coding Agent 与 MCP

- [ ] 记录 coding-agent 产品名和版本。
- [x] 保存脱敏的 DataHub MCP 配置示例，包含 server command/version/transport，但不含凭据。
- [x] 捕获 MCP `tools/list`，证明可用工具集合。
- [x] 保存实际用于生成模型的用户 prompt 与 agent 指令。
- [x] 捕获双 URN `get_entities`，保留时间戳、tool name、arguments、response。
- [x] 捕获影响模型关系决策的 `get_lineage` 空结果。
- [x] 将逐次调用保存为 `examples/payment/03-mcp-tool-calls.jsonl`。
- [x] 从脱敏 JSONL 将本次实际上下文汇总为 `examples/payment/04-datahub-context.json`。
- [x] 验证每个业务字段均能追溯到 MCP context；转换和框架字段写入 decision log。

## 4. 模型生成与校验

- [x] 从本次 MCP context 更新唯一 canonical model：`examples/payment/05-generated-model.xml`。
- [x] 保存模型 diff、决策日志和本轮生成记录，不把旧文件描述为本次新建。
- [x] 通过内网 TeaQL endpoint 运行 model evaluation，保存 command、tool version、stdout/stderr、exit code。
- [x] 记录最终 model SHA-256，并让 generator logs、摘要和决策文档引用同一个 hash。
- [x] 更新 `examples/payment/06-model-decisions.md`，区分 DataHub facts 与 TeaQL framework fields，并删除 unsupported inference。
- [x] Negative check：删除无 DataHub 证据的关系，没有添加缺失业务字段。

## 5. 从空目录生成 Java 与 Rust

- [x] Java 在新建 `/tmp/payment-gen.*` output root 下生成，开始前无 output children。
- [x] 记录 Java generation 的准确 command、版本、model path/hash、output path、开始/结束时间、stdout/stderr、exit code。
- [x] Rust 在同一新建 output root 的独立、尚不存在子目录中生成。
- [x] 记录 Rust generation 的准确 command、版本、model path/hash、output path、开始/结束时间、stdout/stderr、exit code。
- [x] 将最终 canonical outputs 保存到 `examples/payment/07-generated-code/`，旧产物移到 `/tmp` 备份。
- [x] 生成包含相对路径、大小和 SHA-256 的 manifest，并保存 previous-to-final source diff。
- [x] 将原始生成记录保存到 `examples/payment/run/generator.log` 及细分日志。

## 6. 编译准确的生成产物

- [x] 在 evidence host 上针对最终 payment manifests 执行并完整记录：

  ```bash
  TEAQL_TRACE_MODE=off TEAQL_TRACE_OFF_ACK=<acknowledged-value> mvn -f examples/payment/07-generated-code/java-lib-core/lib/pom.xml clean test
  cargo test --manifest-path examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml --locked -v
  ```

- [x] Java 日志包含 command、cwd、manifest、时间戳、exit code、test count 和 duration。
- [x] Rust 日志包含 command、cwd、manifest、crate、时间戳、exit code、test count 和 duration。
- [x] Java 与 Rust 各有 1 个 runtime masking test passed，并分别记录安全边界。
- [x] 保存完整日志到 `examples/payment/run/build-and-test/`。
- [x] 从原始日志更新 `examples/payment/09-test-summary.md`。

## 7. Runtime policy（可选但不能冒充已完成）

- [x] Rust 真实测试读取生成 descriptor policy，调用 `UserContext.send_event` safe-event masking，并断言敏感账号不可见。
- [x] Java 真实测试读取生成 `EntityMetaRegistry` policy，经手写 `MaskingAuditLogger` 输出 safe event 和 TeaQL formatted log，并断言敏感账号不可见。
- N/A — 已完成 Rust runtime safe-event test，不使用仅 propagation 的替代结论。
- N/A — Payment demo 不声明 KYC 或 Spring MVC runtime 行为。
- N/A — Payment demo 不声明 lineage write-back；`get_lineage` 仅用于关系决策。
- [x] 删除 KYC/lineage 替代 masking 的 claims，并披露默认 raw trace logger 边界。
- [x] 更新 `examples/payment/10-context-to-code-map.md`，每条 runtime 结论链接到直接证据。

## 8. 可重复性和失败行为

- [x] 从第二个 clean output directory 重复生成一次。
- [x] 比较两次 generator-owned sources；排除 ZIP、Java 手写 adapter/test 与测试 POM、Rust 手写测试、Cargo.lock 和 build directory 后内容一致。
- [ ] 提供 invalid/incomplete DataHub schema，捕获 agent 的失败或澄清行为。
- [ ] 证明 agent 在缺失关键 context 时不会自行编造事实。
- [x] 记录人工操作、内网 generator endpoint、Cargo offline cache 和 raw logger 配置假设。

## 9. 提交材料

- [x] README 中每个阶段链接到对应原始证据，并保持 verified/pending 状态准确。
- [x] 保存架构图和 context-to-code mapping；内容与本次运行一致。
- [ ] 录制三分钟以内的公开 demo，展示 live MCP call、模型、生成代码和准确的 build/test。
- [ ] 将公开视频链接加入 README 和 Devpost。
- [x] 披露 hackathon 前已有的 TeaQL/runtime/ERP 组件，以及本次新增的 DataHub workflow、payment outputs 和 masking evidence。
- [x] 确认仓库通过公开 GitHub remote 可访问，且 Apache 2.0 `LICENSE` 可见。
- [x] 执行可重复的 secret/PII scan，并保存命令与结果到 `examples/payment/run/security-scan.log`。

## 最终验收

- [x] 所有 `[x]` 项均能指向原始证据文件及其中的准确位置。
- [x] MCP JSONL、context JSON、model、generator log 和 generated outputs 使用本轮运行信息。
- [x] Java/Rust 构建针对最终 payment outputs，而非根目录 ERP 示例或父目录项目。
- [x] `get_lineage` 空结果已捕获，unsupported relationship 已从模型移除。
- [x] runtime masking、KYC、data quality 和 lineage 没有相互替代证明。
- [x] README 没有把手工多阶段流程称为一条自动 end-to-end command。
- [ ] 最终 commit、model hash、timestamps、commands 和 exit codes 在各文档中一致。
