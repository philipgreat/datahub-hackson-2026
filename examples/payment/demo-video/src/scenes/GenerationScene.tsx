import { FadeUp } from "../components/FadeUp";
import { SceneFrame } from "../components/SceneFrame";
import { Terminal } from "../components/Terminal";
import { palette } from "../constants";
import type { TerminalLine } from "../types";

const lines: TerminalLine[] = [
  { at: 18, tone: "muted", text: "$ generator --server.address=127.0.0.1 --server.port=18080" },
  { at: 42, tone: "success", text: "✓ TeaQL Generator 20260804.173835 · loopback only" },
  { at: 78, tone: "command", text: "$ TEAQL_ENDPOINT_PREFIX=http://127.0.0.1:18080/ mvn teaql:generate" },
  { at: 112, tone: "output", text: "using http://127.0.0.1:18080/generate" },
  { at: 142, tone: "success", text: "✓ Java domain generated from empty directory" },
  { at: 182, tone: "command", text: "$ cargo teaql --endpoint-prefix http://127.0.0.1:18080/ ..." },
  { at: 215, tone: "output", text: "using http://127.0.0.1:18080/generate" },
  { at: 245, tone: "success", text: "✓ Rust domain generated from empty directory" },
  { at: 292, tone: "command", text: "$ check_generation_repeatability.sh" },
  { at: 324, tone: "success", text: "✓ Java sources match · Rust sources match" },
  { at: 356, tone: "success", text: "FINAL_VALIDATION=PASS" },
];

export const GenerationScene: React.FC = () => <SceneFrame chapter="LOCAL GENERATION" step="04 / 07">
  <div style={{ display: "grid", gridTemplateColumns: "0.72fr 1.28fr", gap: 54, height: "100%", alignItems: "center" }}>
    <div><FadeUp name="Generation title" delay={6}><div style={{ color: palette.cyan, fontFamily: "monospace", fontSize: 18, fontWeight: 800, letterSpacing: 3 }}>127.0.0.1:18080</div><h2 style={{ margin: "16px 0 0", fontSize: 80, lineHeight: 1.08, letterSpacing: -4 }}>模型不离开<br />受控网络</h2></FadeUp><FadeUp name="Generation facts" delay={30}><div style={{ marginTop: 40, display: "grid", gap: 16 }}>{["Model evaluation · 0 errors", "Java + Rust generated", "Second run deterministic"].map((text) => <div key={text} style={{ display: "flex", gap: 14, color: palette.muted, fontSize: 25 }}><span style={{ color: palette.green }}>✓</span>{text}</div>)}</div></FadeUp></div>
    <FadeUp name="Generator terminal" delay={18} style={{ height: 650 }}><Terminal title="verified-generation.log" lines={lines} style={{ height: "100%" }} /></FadeUp>
  </div>
</SceneFrame>;
