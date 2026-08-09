import { FadeUp } from "../components/FadeUp";
import { SceneFrame } from "../components/SceneFrame";
import { palette } from "../constants";

const nodes = ["Coding Agent", "MCP", "DataHub", "TeaQL Model", "Java + Rust"];

export const OpeningScene: React.FC = () => (
  <SceneFrame chapter="OPENING" step="01 / 07">
    <div style={{ height: "100%", display: "grid", gridTemplateColumns: "1.08fr 0.92fr", gap: 88, alignItems: "center" }}>
      <div>
        <FadeUp name="Opening kicker"><div style={{ color: palette.orange, fontFamily: "monospace", fontSize: 20, fontWeight: 850, letterSpacing: 4 }}>GOVERNANCE-GROUNDED CODE GENERATION</div></FadeUp>
        <FadeUp name="Opening title"><h1 style={{ margin: "22px 0 0", fontSize: 98, lineHeight: 1.02, letterSpacing: -5.2 }}>Bring governance context<br />into code generation</h1></FadeUp>
        <FadeUp name="Opening subtitle"><p style={{ maxWidth: 870, margin: "32px 0 0", color: palette.muted, fontSize: 34, lineHeight: 1.5 }}>A Coding Agent reads DataHub through MCP,<br />then generates verifiable TeaQL apps inside a controlled network.</p></FadeUp>
      </div>
      <div style={{ display: "flex", flexDirection: "column", gap: 14 }}>
        {nodes.map((node, index) => <div key={node} style={{ padding: "23px 28px", border: `1px solid ${index === 2 ? palette.cyan : palette.line}`, borderRadius: 16, backgroundColor: index === 2 ? "rgba(79,225,209,0.12)" : "rgba(13,27,31,0.88)", color: index === 2 ? palette.cyan : palette.text, fontSize: 28, fontWeight: 780 }}><span style={{ color: index === 2 ? palette.cyan : "#597073", marginRight: 20, fontFamily: "monospace", fontSize: 17 }}>{String(index + 1).padStart(2, "0")}</span>{node}</div>)}
      </div>
    </div>
  </SceneFrame>
);
