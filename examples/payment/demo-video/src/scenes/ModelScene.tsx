import { FadeUp } from "../components/FadeUp";
import { SceneFrame } from "../components/SceneFrame";
import { palette } from "../constants";

const CodeLine: React.FC<{ n: number; children: React.ReactNode; highlight?: boolean }> = ({ n, children, highlight }) => (
  <div style={{ display: "grid", gridTemplateColumns: "42px 1fr", padding: "7px 16px", backgroundColor: highlight ? "rgba(79,225,209,0.11)" : "transparent", borderLeft: highlight ? `3px solid ${palette.cyan}` : "3px solid transparent" }}>
    <span style={{ color: "#486063" }}>{n}</span><span>{children}</span>
  </div>
);

export const ModelScene: React.FC = () => (
  <SceneFrame chapter="CONTEXT TO MODEL" step="03 / 07">
    <FadeUp name="Model title" delay={5}>
      <div style={{ color: palette.cyan, fontFamily: "monospace", fontSize: 18, fontWeight: 800, letterSpacing: 3 }}>MCP CONTEXT → TEAQL POLICY</div>
      <h2 style={{ margin: "14px 0 34px", fontSize: 72, letterSpacing: -3 }}>治理信息直接改变生成模型</h2>
    </FadeUp>
    <div style={{ display: "grid", gridTemplateColumns: "0.88fr 1.12fr", gap: 30, height: 610 }}>
      <FadeUp name="DataHub input" delay={22} style={{ height: "100%" }}>
        <div style={{ height: "100%", padding: 30, border: `1px solid ${palette.line}`, borderRadius: 20, backgroundColor: "rgba(13,27,31,0.92)" }}>
          <div style={{ display: "flex", justifyContent: "space-between" }}><span style={{ color: palette.orange, fontFamily: "monospace", fontSize: 16, fontWeight: 850 }}>DATAHUB / get_entities</span><span style={{ color: palette.green, fontFamily: "monospace", fontSize: 13 }}>REAL MCP RESPONSE</span></div>
          <div style={{ marginTop: 28, color: palette.muted, fontFamily: "monospace", fontSize: 18, lineHeight: 1.75 }}><div><span style={{ color: palette.cyan }}>name:</span> payment_transactions</div><div><span style={{ color: palette.cyan }}>field:</span> payment_account</div><div><span style={{ color: palette.cyan }}>nativeDataType:</span> VARCHAR</div><div><span style={{ color: palette.cyan }}>nullable:</span> false</div></div>
          <div style={{ marginTop: 30, padding: 24, borderRadius: 14, border: `1px solid ${palette.orange}44`, backgroundColor: "rgba(255,138,76,0.09)", color: "#ffc09f", fontSize: 23, lineHeight: 1.55 }}>“包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。”</div>
          <div style={{ marginTop: 26, color: palette.green, fontSize: 19, fontWeight: 760 }}>✓ lineage upstream total = 0</div>
        </div>
      </FadeUp>
      <FadeUp name="TeaQL output" delay={38} style={{ height: "100%" }}>
        <div style={{ height: "100%", border: `1px solid ${palette.line}`, borderRadius: 20, overflow: "hidden", backgroundColor: "#081316" }}>
          <div style={{ height: 54, display: "flex", alignItems: "center", justifyContent: "space-between", padding: "0 20px", borderBottom: `1px solid ${palette.line}`, backgroundColor: "#102126" }}><span style={{ fontFamily: "monospace", fontSize: 16 }}>05-generated-model.xml</span><span style={{ color: palette.green, fontFamily: "monospace", fontSize: 13 }}>MODEL EVAL · 0 ERRORS</span></div>
          <div style={{ padding: "24px 0", fontFamily: "monospace", fontSize: 19, lineHeight: 1.55 }}>
            <CodeLine n={18}>&lt;entity name=<span style={{ color: palette.orange }}>"payment_transaction"</span></CodeLine>
            <CodeLine n={19}>{"  "}table=<span style={{ color: palette.orange }}>"payment_transaction_data"</span></CodeLine>
            <CodeLine n={20}>{"  "}transaction_amount=<span style={{ color: palette.cyan }}>"money()"</span></CodeLine>
            <CodeLine n={21} highlight>{"  "}payment_account=<span style={{ color: palette.cyan }}>"string()"</span></CodeLine>
            <CodeLine n={22}>{"  "}currency_code=<span style={{ color: palette.cyan }}>"string()"</span></CodeLine>
            <CodeLine n={23}>{"  "}payment_method=<span style={{ color: palette.cyan }}>"string()"</span></CodeLine>
            <CodeLine n={24} highlight>{"  "}_audit_mask_fields=<span style={{ color: palette.green }}>"payment_account"</span> /&gt;</CodeLine>
          </div>
          <div style={{ margin: "18px 28px", padding: "18px 22px", borderRadius: 13, backgroundColor: "rgba(79,225,209,0.09)", color: palette.cyan, fontSize: 20, fontWeight: 740 }}>→ Sensitive context becomes executable policy — no invented relation.</div>
        </div>
      </FadeUp>
    </div>
  </SceneFrame>
);
