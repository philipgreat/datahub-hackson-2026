import type { Caption } from "@remotion/captions";
import { useCallback, useEffect, useState } from "react";
import { AbsoluteFill, staticFile, useCurrentFrame, useDelayRender, useVideoConfig } from "remotion";
import { palette } from "../constants";

export const CaptionOverlay: React.FC = () => {
  const frame = useCurrentFrame();
  const { fps } = useVideoConfig();
  const [captions, setCaptions] = useState<Caption[] | null>(null);
  const { delayRender, continueRender, cancelRender } = useDelayRender();
  const [handle] = useState(() => delayRender("Loading burned-in captions"));
  const load = useCallback(async () => {
    try {
      const response = await fetch(staticFile("captions.json"));
      if (!response.ok) throw new Error(`Caption fetch failed: ${response.status}`);
      setCaptions((await response.json()) as Caption[]);
      continueRender(handle);
    } catch (error) {
      cancelRender(error instanceof Error ? error : new Error(String(error)));
    }
  }, [cancelRender, continueRender, handle]);
  useEffect(() => { load(); }, [load]);
  if (!captions) return null;
  const currentTimeMs = (frame / fps) * 1000;
  const caption = captions.find((item) => item.startMs <= currentTimeMs && item.endMs > currentTimeMs);
  if (!caption) return null;
  return (
    <AbsoluteFill style={{ justifyContent: "flex-end", alignItems: "center", paddingBottom: 54, pointerEvents: "none" }}>
      <div style={{ maxWidth: 1500, padding: "16px 30px 18px", border: `1px solid ${palette.line}`, borderRadius: 14, backgroundColor: "rgba(5,12,14,0.92)", color: palette.text, fontSize: 34, fontWeight: 720, lineHeight: 1.45, textAlign: "center", boxShadow: "0 18px 60px rgba(0,0,0,0.35)" }}>{caption.text}</div>
    </AbsoluteFill>
  );
};
