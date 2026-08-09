import type { PropsWithChildren } from "react";
import { AbsoluteFill, Easing, Interactive, interpolate, useCurrentFrame } from "remotion";
import { palette, VERIFIED_SOURCE_COMMIT } from "../constants";

export const SceneFrame: React.FC<PropsWithChildren<{ chapter: string; step: string; accent?: string }>> = ({ chapter, step, accent = palette.cyan, children }) => {
  const frame = useCurrentFrame();
  return (
    <AbsoluteFill style={{ backgroundColor: palette.background, color: palette.text, overflow: "hidden" }}>
      <AbsoluteFill style={{ opacity: 0.34, backgroundImage: "linear-gradient(rgba(255,255,255,0.035) 1px, transparent 1px), linear-gradient(90deg, rgba(255,255,255,0.035) 1px, transparent 1px)", backgroundSize: "52px 52px" }} />
      <div style={{ position: "absolute", width: 760, height: 760, right: -260, top: -330, borderRadius: "50%", backgroundColor: accent, filter: "blur(150px)", opacity: 0.1 }} />
      <Interactive.Div name="Scene header" style={{
        position: "absolute", left: 88, right: 88, top: 56, display: "flex", alignItems: "center", justifyContent: "space-between",
        opacity: interpolate(frame, [0, 18], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(0.16, 1, 0.3, 1) }),
      }}>
        <div style={{ display: "flex", alignItems: "center", gap: 18 }}>
          <div style={{ display: "grid", placeItems: "center", width: 54, height: 54, border: `1px solid ${accent}66`, borderRadius: 15, backgroundColor: `${accent}14`, color: accent, fontSize: 16, fontWeight: 850 }}>D×T</div>
          <div><div style={{ fontSize: 17, fontWeight: 780 }}>DataHub × TeaQL</div><div style={{ marginTop: 5, color: palette.muted, fontFamily: "monospace", fontSize: 12, letterSpacing: 2.2 }}>VERIFIED RUN REPLAY · SOURCE {VERIFIED_SOURCE_COMMIT}</div></div>
        </div>
        <div style={{ display: "flex", alignItems: "center", gap: 14 }}><span style={{ width: 8, height: 8, borderRadius: "50%", backgroundColor: accent, boxShadow: `0 0 14px ${accent}` }} /><span style={{ color: accent, fontFamily: "monospace", fontSize: 13, fontWeight: 800, letterSpacing: 2 }}>{step} · {chapter}</span></div>
      </Interactive.Div>
      <div style={{ position: "absolute", left: 88, right: 88, top: 130, height: 1, backgroundColor: palette.line }} />
      <AbsoluteFill style={{ padding: "164px 88px 170px" }}>{children}</AbsoluteFill>
    </AbsoluteFill>
  );
};
