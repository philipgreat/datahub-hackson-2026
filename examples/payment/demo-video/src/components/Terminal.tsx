import { Easing, Interactive, interpolate, useCurrentFrame } from "remotion";
import { palette } from "../constants";
import type { TerminalLine } from "../types";

const toneColor = (tone: TerminalLine["tone"]) => tone === "command" ? palette.cyan : tone === "success" ? palette.green : tone === "error" ? palette.red : tone === "muted" ? "#617779" : "#c9d4d2";

export const Terminal: React.FC<{ title: string; lines: TerminalLine[]; style?: React.CSSProperties }> = ({ title, lines, style }) => {
  const frame = useCurrentFrame();
  return (
    <Interactive.Div name={title} style={{ border: `1px solid ${palette.line}`, borderRadius: 22, overflow: "hidden", backgroundColor: "rgba(5,12,14,0.96)", boxShadow: "0 32px 80px rgba(0,0,0,0.28)", ...style }}>
      <div style={{ height: 58, display: "flex", alignItems: "center", gap: 10, padding: "0 22px", borderBottom: `1px solid ${palette.line}`, backgroundColor: "#102025" }}>
        {[palette.red, "#f2c65c", palette.green].map((color) => <span key={color} style={{ width: 12, height: 12, borderRadius: "50%", backgroundColor: color, opacity: 0.85 }} />)}
        <span style={{ marginLeft: 14, color: palette.muted, fontFamily: "monospace", fontSize: 15 }}>{title}</span>
      </div>
      <div style={{ padding: "26px 30px", fontFamily: "monospace", fontSize: 20, lineHeight: 1.62 }}>
        {lines.map((line, index) => <div key={`${line.at}-${index}`} style={{ minHeight: 32, color: toneColor(line.tone), opacity: interpolate(frame, [line.at, line.at + 8], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(0.16, 1, 0.3, 1) }), transform: `translateY(${interpolate(frame, [line.at, line.at + 8], [8, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(0.16, 1, 0.3, 1) })}px)` }}>{frame >= line.at ? line.text : ""}</div>)}
      </div>
    </Interactive.Div>
  );
};
