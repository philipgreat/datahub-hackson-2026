const base = "..";

const steps = [
  {
    chapter: "OPENING",
    name: "问题与架构",
    duration: 20,
    title: "把治理上下文带进代码生成",
    subtitle: "Coding Agent 通过 MCP 读取 DataHub，再在内网生成可验证的 TeaQL 应用。",
    talk:
      "很多代码生成只看一段提示词。我们的流程让 Coding Agent 先读取企业真实的数据目录、字段和治理说明，再决定模型应该长什么样。",
    actionTitle: "打开项目总览",
    actionDetail: "先让评委看到完整链路，再进入 DataHub 细节。",
    focus: "指向架构图中的 Coding Agent → MCP → DataHub，以及本机内网 generator。",
    avoid: "不要说这是运行时 MCP。MCP 只辅助 Coding Agent 建模和生成。",
    resources: [
      { label: "项目总览", path: "../../../README.md", display: "README.md" },
    ],
  },
  {
    chapter: "SOURCE OF TRUTH",
    name: "DataHub 数据源",
    duration: 30,
    title: "先读取企业真实的数据上下文",
    subtitle: "payment_transactions 的字段、描述和 lineage 都来自 DataHub，而不是模型猜测。",
    talk:
      "这里是 DataHub 中真实存在的支付流水表。它明确包含 payment_account，并声明支付账号属于高度敏感信息。",
    actionTitle: "打开 DataHub，搜索 payment_transactions",
    actionDetail: "点击 Schema，停在四个业务字段和敏感说明处。",
    focus: "字段列表、表描述，以及 payment_account。必要时再展示 lineage upstream 为 0。",
    avoid: "不要在屏幕上展开 Owner、Cookie、Token 或其他可能含个人信息的内容。",
    resources: [
      { label: "打开 DataHub", path: "http://localhost:9002", display: "localhost:9002", external: true },
      { label: "整理后的 DataHub 上下文", path: `${base}/04-datahub-context.json`, display: "04-datahub-context.json" },
    ],
  },
  {
    chapter: "CONTEXT TO MODEL",
    name: "MCP 到模型",
    duration: 30,
    title: "治理信息直接改变生成模型",
    subtitle: "敏感字段被保留为业务字段，同时自动进入 _audit_mask_fields。",
    talk:
      "Agent 没有添加 DataHub 中不存在的字段或关系。它把 payment_account 映射为字符串，并把敏感治理要求映射成审计脱敏策略。",
    actionTitle: "并排展示上下文与 TeaQL XML",
    actionDetail: "先指 DataHub 描述，再指模型中的 payment_account 和 _audit_mask_fields。",
    focus: "三行就够：字段来源、string() 类型、_audit_mask_fields=payment_account。",
    avoid: "不要把 masking 说成删除字段；字段仍服务业务，只在安全审计输出中脱敏。",
    resources: [
      { label: "TeaQL 模型", path: `${base}/05-generated-model.xml`, display: "05-generated-model.xml" },
      { label: "上下文到代码映射", path: `${base}/10-context-to-code-map.md`, display: "10-context-to-code-map.md" },
      { label: "模型决策", path: `${base}/06-model-decisions.md`, display: "06-model-decisions.md" },
    ],
  },
  {
    chapter: "LOCAL GENERATION",
    name: "内网生成",
    duration: 25,
    title: "模型不离开受控网络",
    subtitle: "Java 与 Rust 客户端都调用 127.0.0.1:18080 的内部 TeaQL Generator。",
    talk:
      "生成器和 Coding Agent 位于同一台受控机器。模型通过 loopback endpoint 完成校验和生成，不需要发送到公共生成服务。",
    actionTitle: "打开 generator 和生成日志",
    actionDetail: "快速展示 endpoint、模型校验 0 errors，以及 Java/Rust 两条生成记录。",
    focus: "127.0.0.1:18080、evaluate 成功、Java 和 Rust 输出。",
    avoid: "不要现场重新生成；视频使用已经提交的真实运行日志，节奏更稳定。",
    resources: [
      { label: "Generator 运行说明", path: `${base}/run/generator.log`, display: "run/generator.log" },
      { label: "模型校验", path: `${base}/run/model-eval.log`, display: "run/model-eval.log" },
      { label: "Java 生成", path: `${base}/run/maven_generate.log`, display: "run/maven_generate.log" },
      { label: "Rust 生成", path: `${base}/run/cargo_generate.log`, display: "run/cargo_generate.log" },
    ],
  },
  {
    chapter: "RUNTIME PROOF",
    name: "Java / Rust 脱敏",
    duration: 40,
    title: "同一治理策略，在两种运行时生效",
    subtitle: "Raw 取证路径与 Safe 分析路径分离；外发安全事件根据生成元数据脱敏。",
    talk:
      "原始审计事件服务受控取证和调试；面向分析系统的 SafeAuditEvent 会读取生成的 audit_mask_fields，在输出前屏蔽 payment_account。Java 和 Rust 都有实际测试证据。",
    actionTitle: "先展示 Java，再展示 Rust 日志标记",
    actionDetail: "在两个日志中分别搜索 JAVA_MASKING_EVIDENCE 和 MASKING_EVIDENCE。",
    focus: "masked=true、reason=_audit_mask_fields、raw_present=false，同时 currency_code 保持可见。",
    avoid: "不要说所有 raw trace 都脱敏；被验证的是 SafeAuditEvent 分析出口。",
    resources: [
      { label: "Java masking 日志", path: `${base}/run/build-and-test/payment-service-java.log`, display: "payment-service-java.log" },
      { label: "Rust masking 日志", path: `${base}/run/build-and-test/payment-service-rust.log`, display: "payment-service-rust.log" },
      { label: "Java 策略适配器", path: `${base}/07-generated-code/java-lib-core/lib/src/main/java/com/example/paymentservice/audit/MaskingAuditLogger.java`, display: "MaskingAuditLogger.java" },
      { label: "Rust generated descriptor", path: `${base}/07-generated-code/rust-lib-core/lib/src/payment_transaction/entity.rs`, display: "payment_transaction/entity.rs" },
    ],
  },
  {
    chapter: "FAIL CLOSED",
    name: "不虚构上下文",
    duration: 25,
    title: "缺少证据时，Agent 拒绝生成",
    subtitle: "不存在的 DataHub URN 不会被补成看似合理的字段和关系。",
    talk:
      "我们还测试了失败路径。DataHub 返回 entity not found 后，Agent 明确拒绝生成，业务字段和关系数组都为空，并要求提供有效 URN。",
    actionTitle: "打开负向测试摘要",
    actionDetail: "停在 REFUSE_MISSING_CONTEXT、空数组和最终 PASS 标记。",
    focus: "can_generate=false、generated_business_fields=[]、generated_relations=[]。",
    avoid: "不要只口头说没有 hallucination；一定让机械验证 PASS 出现在画面里。",
    resources: [
      { label: "负向测试摘要", path: `${base}/run/agent-negative-schema-summary.log`, display: "agent-negative-schema-summary.log" },
      { label: "行为说明", path: `${base}/11-negative-agent-behavior.md`, display: "11-negative-agent-behavior.md" },
      { label: "测试提示词", path: `${base}/run/agent-negative-schema-prompt.txt`, display: "agent-negative-schema-prompt.txt" },
    ],
  },
  {
    chapter: "CLOSE",
    name: "价值总结",
    duration: 10,
    title: "从数据治理，到可运行代码",
    subtitle: "可追溯、可复现、默认安全，并且适合企业内网的 Coding Agent 工作流。",
    talk:
      "这个方案的价值不是多生成一份代码，而是让企业已有的 DataHub 治理上下文真正约束模型、代码和运行时行为。",
    actionTitle: "回到证据总览，结束演示",
    actionDetail: "停在 VERIFIED 表格，让评委看到完整证据链。",
    focus: "DataHub grounded、local generation、runtime masking、fail closed。",
    avoid: "不要声称完全无人值守的端到端自动化；这是有证据约束的多阶段 Agent 工作流。",
    resources: [
      { label: "证据总览", path: "../../../EVIDENCE.md", display: "EVIDENCE.md" },
      { label: "测试摘要", path: `${base}/09-test-summary.md`, display: "09-test-summary.md" },
    ],
  },
];

let currentStep = 0;
let running = false;
let startedAt = null;
let accumulatedSeconds = 0;
let ticker = null;

const elements = {
  stepNav: document.querySelector("#stepNav"),
  chapter: document.querySelector("#chapter"),
  timeChip: document.querySelector("#timeChip"),
  stepCounter: document.querySelector("#stepCounter"),
  title: document.querySelector("#title"),
  subtitle: document.querySelector("#subtitle"),
  talkTrack: document.querySelector("#talkTrack"),
  actionTitle: document.querySelector("#actionTitle"),
  actionDetail: document.querySelector("#actionDetail"),
  resourceList: document.querySelector("#resourceList"),
  focusText: document.querySelector("#focusText"),
  avoidText: document.querySelector("#avoidText"),
  progressFill: document.querySelector("#progressFill"),
  previousButton: document.querySelector("#previousButton"),
  nextButton: document.querySelector("#nextButton"),
  startButton: document.querySelector("#startButton"),
  resetButton: document.querySelector("#resetButton"),
  captionButton: document.querySelector("#captionButton"),
  elapsed: document.querySelector("#elapsed"),
  runStatus: document.querySelector("#runStatus"),
  toast: document.querySelector("#toast"),
};

function formatTime(totalSeconds) {
  const seconds = Math.max(0, Math.floor(totalSeconds));
  const minutes = Math.floor(seconds / 60).toString().padStart(2, "0");
  const remainder = (seconds % 60).toString().padStart(2, "0");
  return `${minutes}:${remainder}`;
}

function elapsedSeconds() {
  if (!running || !startedAt) return accumulatedSeconds;
  return accumulatedSeconds + (Date.now() - startedAt) / 1000;
}

function updateTimer() {
  const seconds = elapsedSeconds();
  elements.elapsed.textContent = formatTime(seconds);
  elements.runStatus.textContent = seconds > 180 ? "OVERTIME" : running ? "LIVE" : "PAUSED";
  document.documentElement.style.setProperty("--timer-accent", seconds > 180 ? "var(--orange)" : "var(--cyan)");
}

function toggleTimer() {
  if (running) {
    accumulatedSeconds = elapsedSeconds();
    running = false;
    startedAt = null;
    clearInterval(ticker);
    elements.startButton.textContent = "继续演示";
  } else {
    running = true;
    startedAt = Date.now();
    ticker = setInterval(updateTimer, 250);
    elements.startButton.textContent = "暂停计时";
  }
  updateTimer();
}

function resetRun() {
  running = false;
  startedAt = null;
  accumulatedSeconds = 0;
  clearInterval(ticker);
  currentStep = 0;
  elements.startButton.textContent = "开始演示";
  elements.runStatus.textContent = "READY";
  elements.elapsed.textContent = "00:00";
  render();
}

function showToast(message) {
  elements.toast.textContent = message;
  elements.toast.classList.add("visible");
  window.setTimeout(() => elements.toast.classList.remove("visible"), 1400);
}

function renderNav() {
  elements.stepNav.innerHTML = "";
  steps.forEach((step, index) => {
    const button = document.createElement("button");
    button.type = "button";
    button.className = `step-link${index === currentStep ? " active" : ""}`;
    button.innerHTML = `
      <span class="step-index">${String(index + 1).padStart(2, "0")}</span>
      <span class="step-name">${step.name}</span>
      <span class="step-duration">${step.duration}s</span>
    `;
    button.addEventListener("click", () => {
      currentStep = index;
      render();
    });
    elements.stepNav.appendChild(button);
  });
}

function resourceControl(resource) {
  const item = document.createElement("div");
  item.className = "resource-item";
  const absolutePath = resource.external
    ? resource.path
    : `/home/philip/githome/datahub-hackson-2026${new URL(resource.path, window.location.href).pathname}`;
  item.innerHTML = `
    <div class="resource-meta">
      <strong>${resource.label}</strong>
      <code title="${resource.display}">${resource.display}</code>
    </div>
  `;

  const action = document.createElement(resource.external || resource.path ? "a" : "button");
  action.className = "open-link";
  action.textContent = "↗";
  action.setAttribute("aria-label", `打开 ${resource.label}`);
  action.title = `打开 ${resource.display}`;
  action.href = resource.path;
  action.target = "_blank";
  action.rel = "noreferrer";
  action.addEventListener("contextmenu", async (event) => {
    event.preventDefault();
    try {
      await navigator.clipboard.writeText(absolutePath);
      showToast("已复制路径");
    } catch {
      showToast("无法复制，请直接打开链接");
    }
  });
  item.appendChild(action);
  return item;
}

function render() {
  const step = steps[currentStep];
  renderNav();
  elements.chapter.textContent = step.chapter;
  elements.timeChip.textContent = `建议 ${step.duration} 秒`;
  elements.stepCounter.textContent = `${String(currentStep + 1).padStart(2, "0")} / ${String(steps.length).padStart(2, "0")}`;
  elements.title.textContent = step.title;
  elements.subtitle.textContent = step.subtitle;
  elements.talkTrack.textContent = step.talk;
  elements.actionTitle.textContent = step.actionTitle;
  elements.actionDetail.textContent = step.actionDetail;
  elements.focusText.textContent = step.focus;
  elements.avoidText.textContent = step.avoid;
  elements.progressFill.style.width = `${((currentStep + 1) / steps.length) * 100}%`;
  elements.previousButton.disabled = currentStep === 0;
  elements.nextButton.disabled = currentStep === steps.length - 1;
  elements.nextButton.innerHTML = currentStep === steps.length - 2 ? "进入总结 <span>→</span>" : "下一步 <span>→</span>";

  elements.resourceList.innerHTML = "";
  step.resources.forEach((resource) => elements.resourceList.appendChild(resourceControl(resource)));

  const oldCard = document.querySelector(".caption-card");
  oldCard.style.animation = "none";
  requestAnimationFrame(() => {
    oldCard.style.animation = "";
  });
}

function goNext() {
  if (currentStep < steps.length - 1) {
    currentStep += 1;
    render();
  }
}

function goPrevious() {
  if (currentStep > 0) {
    currentStep -= 1;
    render();
  }
}

elements.nextButton.addEventListener("click", goNext);
elements.previousButton.addEventListener("click", goPrevious);
elements.startButton.addEventListener("click", toggleTimer);
elements.resetButton.addEventListener("click", resetRun);
elements.captionButton.addEventListener("click", () => {
  document.body.classList.toggle("caption-mode");
  elements.captionButton.textContent = document.body.classList.contains("caption-mode") ? "退出字幕" : "字幕模式";
});
document.querySelector(".brand").addEventListener("click", (event) => {
  event.preventDefault();
  currentStep = 0;
  render();
});

document.addEventListener("keydown", (event) => {
  if (event.key === "ArrowRight" || event.key === " ") {
    event.preventDefault();
    goNext();
  } else if (event.key === "ArrowLeft") {
    event.preventDefault();
    goPrevious();
  } else if (event.key.toLowerCase() === "f") {
    document.body.classList.toggle("caption-mode");
  } else if (/^[1-7]$/.test(event.key)) {
    currentStep = Number(event.key) - 1;
    render();
  }
});

render();
