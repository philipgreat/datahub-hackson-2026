@EVIDENCE_FIX.md 按照本文执行全部 FIX，验证修改结果；不要执行或伪造 `EVIDENCE_TODO.md` 中的环境取证任务。

# Evidence Fix Prompt

本文是交给 coding agent 的直接执行指令。目标是修复当前仓库中已经能够通过现有文件确认的问题，使所有文字、状态和脚本与已提交证据严格一致。

## 工作边界

- 可以修改文档、模型决策说明、验证脚本以及不依赖新证据的代码。
- 不得伪造、补写或概括不存在的 MCP 调用、Docker 输出、生成器输出、测试日志、截图或视频。
- 不得仅凭任务曾被执行就把状态写成 `VERIFIED`。
- 不得执行或勾选 `EVIDENCE_TODO.md`；TODO 只能在相应原始证据实际生成并复核后更新。
- 原始日志原则上保持原样。若日志本身是模拟输出或信息不足，应在摘要中明确其局限，不能改写成真实运行记录。
- 保留与本任务无关的用户修改，不要 force push。

## 开始前

1. 获取并快进到最新 `origin/main`，记录起始 commit 和 `git status --short`。
2. 阅读 `README.md`、`EVIDENCE.md`、`EVIDENCE_TODO.md`、`examples/payment/` 下的证据文件、适用的 `AGENTS.md`，以及 `skills/datahub-to-teaql/SKILL.md`。
3. 逐项以原始 JSONL、JSON、XML 和日志为准，不以摘要或复选框作为事实来源。

## 必须完成的 FIX

### FIX-1：纠正 unsupported relationship / glossary 声明

当前 `examples/payment/06-model-decisions.md` 声称 `payment_account` 与 `user_account` 具有相同的 `UserAccountID` glossary term，但现有 `03-mcp-tool-calls.jsonl`、`04-datahub-context.json` 和 ingestion 脚本没有提供该证据。

- 删除“DataHub glossary 已证明该关系”的表述。
- 把 `payment_account -> user_account` 明确标成 agent/TeaQL 建模推断，而不是 DataHub 已验证关系。
- 若不重新生成模型与代码，不要擅自改变模型结构；只需准确披露推断及其风险。
- 删除或改写 `zero-hallucination`、`strict schema alignment` 等与现有证据不符的说法。
- 框架生成的 ID、version、时间戳等字段应标为 TeaQL infrastructure fields，而非 DataHub business fields。

### FIX-2：让 EVIDENCE 与实际 MCP 记录完全一致

- 从 `examples/payment/03-mcp-tool-calls.jsonl` 机械地同步 `EVIDENCE.md` 中的 MCP 时间戳、工具名、参数和 URN 列表。
- 不得保留旧时间戳、单 URN 示例或与 JSONL 不同的请求体后再称其为“captured”。
- XML 片段和映射表必须与 `examples/payment/05-generated-model.xml` 的实际语法一致，包括 `_audit_mask_fields` 的位置。

### FIX-3：收窄验证结论

统一 README、EVIDENCE、测试摘要和 context-to-code map 中的状态：

- 可声明已验证：现有 MCP `get_entities` 返回、模型中 policy metadata 的存在、在线生成器已有成功记录、最终 Java/Rust library 的现有编译记录。
- 必须声明未验证或证据不足：payment runtime masking、DataHub relationship grounding、lineage write-back、完整 Spring MVC 注册/集成、干净环境的一键端到端复现。
- Java KYC 的直接类实例化测试不能描述为 Spring MVC 集成测试或 masking 测试。
- Rust numeric filter 测试不能描述为 masking 或 lineage 测试。
- ERP 示例的测试不能证明 payment-service runtime policy。
- `rust-web-topcoat/lib` 只能描述为 generated library 编译；不能描述为 Topcoat web application 已验证。

### FIX-4：纠正 README 的复现范围

- 将 `Reproducible End-to-End Run Command` 改为准确标题，例如 `Repository Build and Evidence Summary Command`。
- 明确 `ingest_payment.py` 与 `run_all.sh` 不会自动执行 external coding-agent MCP、模型生成或 TeaQL 在线生成。
- 将流程拆成 DataHub setup、external coding-agent MCP、TeaQL generation、generated-output build/test 四个阶段。
- 每个阶段使用 `VERIFIED`、`PARTIALLY VERIFIED`、`PENDING` 或 `N/A`，并链接到直接原始证据。

### FIX-5：修正假的完成状态和模拟证据表述

- `EVIDENCE_TODO.md` 必须保留未完成项；不得全量 `[x]`。
- `examples/payment/run/datahub-setup.log` 当前若仍写有 `Mocked via Python script`，摘要必须将真实 Docker health check 标成未捕获。
- `environment.txt` 若显示工作树有修改，不能声称“生成前 clean”。
- 缺少 screenshots、公开 demo video、工具版本、`tools/list`、`get_lineage`、failure behavior、determinism 或 runtime test 时，必须保持 TODO 或标注 `N/A — 原因`。

### FIX-6：改进本地验证脚本，但不制造结果

检查并修复 `run_all.sh`：

- 所有 Maven/Cargo 调用使用明确 manifest 路径。
- manifest 缺失时记录 `SKIPPED` 或失败，不得仍统一打印 `DONE`。
- 禁止 Cargo 向父目录搜索并误编译无关项目。
- 每个模块记录 command、cwd、manifest、exit code 和 duration。
- 区分 `compiled with zero tests`、`tests passed`、`pending` 和 `skipped`。
- 不要用新脚本逻辑倒推或改写旧的原始日志。

### FIX-7：清理剩余的过度声明和敏感信息

搜索并逐项核实下列表述：

```text
runtime masking verified
full Spring MVC
lineage reported successfully
zero hallucination
strict schema alignment
complete end-to-end
flawless
exact same policy mechanism
```

- 无直接原始证据的一律删除、收窄或标为 pending/inference。
- 发布型文档不得包含 token、cookie、authorization header、私人 URL、邮箱、用户名或无关企业元数据。
- 原始日志中的本机路径如必须保留，应明确其来源和范围；摘要统一使用 `<workspace>`。

## 验证要求

完成修改后：

1. 运行 `git diff --check`。
2. 校验 Markdown 中引用的本地路径均存在；明确标注尚未创建的 TODO 目标除外。
3. 用脚本或人工比对确保 `EVIDENCE.md` 的 MCP 请求与 JSONL 一致、XML 与最终模型一致。
4. 搜索上述过度声明，并逐项说明保留依据。
5. 确认 `EVIDENCE_TODO.md` 没有因本次静态修复被虚假勾选。
6. 查看完整 diff，确保没有修改原始证据来迎合结论。

## 输出与提交

完成后提交并推送当前分支，不要 force push。最终报告必须包含：

- commit SHA 和分支；
- 修改了哪些文件；
- 每个 FIX 的处理结果；
- 运行了哪些验证及结果；
- 哪些事项仍留在 `EVIDENCE_TODO.md`；
- 明确声明本轮没有新增哪些 Docker/MCP/runtime 证据。

## 完成标准

- 文档不再把 agent inference 写成 DataHub fact。
- 同一事实在 README、EVIDENCE、决策日志和测试摘要中没有冲突。
- 所有 `VERIFIED` 都能指向当前仓库中的直接原始证据。
- 脚本不会因 manifest 缺失或 Cargo 父目录搜索产生假阳性。
- TODO 保持真实，且与 FIX 完全分离。
