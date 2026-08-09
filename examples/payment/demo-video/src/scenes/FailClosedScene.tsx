import { FadeUp } from "../components/FadeUp";
import { SceneFrame } from "../components/SceneFrame";
import { Terminal } from "../components/Terminal";
import { palette } from "../constants";
import type { TerminalLine } from "../types";

const lines: TerminalLine[] = [
  { at: 18, tone: "command", text: "$ coding-agent generate missing_customer_risk" },
  { at: 54, tone: "output", text: "→ MCP get_entities(urn:li:dataset:...missing_customer_risk...)" },
  { at: 98, tone: "error", text: "Entity ...missing_customer_risk... not found" },
  { at: 150, tone: "output", text: '"decision": "REFUSE_MISSING_CONTEXT"' },
  { at: 180, tone: "output", text: '"can_generate": false' },
  { at: 210, tone: "output", text: '"generated_business_fields": []' },
  { at: 240, tone: "output", text: '"generated_relations": []' },
  { at: 290, tone: "success", text: "NEGATIVE_AGENT_ASSERTIONS=PASS" },
];

export const FailClosedScene: React.FC = () => (
  <SceneFrame chapter="FAIL CLOSED" step="06 / 07" accent={palette.orange}>
    <div style={{ display: "grid", gridTemplateColumns: "0.7fr 1.3fr", gap: 56, height: "100%", alignItems: "center" }}>
      <div>
        <FadeUp name="Fail closed title" delay={5}>
          <div style={{ color: palette.orange, fontFamily: "monospace", fontSize: 18, fontWeight: 800, letterSpacing: 3 }}>NO EVIDENCE · NO GENERATION</div>
          <h2 style={{ margin: "16px 0 0", fontSize: 76, lineHeight: 1.08, letterSpacing: -4 }}>No context?<br />The Agent refuses to invent.</h2>
        </FadeUp>
        <FadeUp name="Fail closed summary" delay={36}>
          <p style={{ margin: "34px 0 0", color: palette.muted, fontSize: 27, lineHeight: 1.55 }}>A missing DataHub URN is never filled with plausible-looking fields or relationships.</p>
        </FadeUp>
        <FadeUp name="Fail closed pass" delay={95}>
          <div style={{ marginTop: 36, display: "inline-flex", padding: "15px 20px", border: `1px solid ${palette.green}55`, borderRadius: 12, backgroundColor: "rgba(114,230,166,0.09)", color: palette.green, fontFamily: "monospace", fontSize: 18, fontWeight: 850 }}>✓ MECHANICALLY VERIFIED</div>
        </FadeUp>
      </div>
      <FadeUp name="Negative test terminal" delay={18} style={{ height: 650 }}>
        <Terminal title="agent-negative-schema-summary.log" lines={lines} style={{ height: "100%" }} />
      </FadeUp>
    </div>
  </SceneFrame>
);
