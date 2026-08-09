import { AbsoluteFill, CanvasImage, staticFile } from "remotion";
import { FadeUp } from "../components/FadeUp";
import { palette } from "../constants";

export const DataHubScene: React.FC = () => (
  <AbsoluteFill style={{ backgroundColor: palette.background }}>
    <CanvasImage
      src={staticFile("datahub-payment-transactions.jpg")}
      style={{ width: "100%", height: "100%", objectFit: "cover" }}
    />
    <AbsoluteFill style={{ background: "linear-gradient(180deg, rgba(4,11,14,0.32) 0%, transparent 24%, transparent 72%, rgba(4,11,14,0.42) 100%)" }} />
    <FadeUp name="Real DataHub evidence" delay={8} style={{ position: "absolute", top: 70, left: 88 }}>
      <div style={{ display: "inline-flex", alignItems: "center", gap: 13, padding: "14px 20px", border: "1px solid rgba(255,255,255,0.24)", borderRadius: 999, backgroundColor: "rgba(5,12,14,0.84)", boxShadow: "0 18px 48px rgba(0,0,0,0.25)", color: "white", fontFamily: "monospace", fontSize: 18, fontWeight: 800, letterSpacing: 1.7 }}>
        <span style={{ width: 10, height: 10, borderRadius: "50%", backgroundColor: palette.green, boxShadow: `0 0 18px ${palette.green}` }} />
        REAL DATAHUB UI · SSH-TUNNELED CAPTURE
      </div>
    </FadeUp>
    <FadeUp name="DataHub PII proof" delay={40} style={{ position: "absolute", right: 88, bottom: 150 }}>
      <div style={{ padding: "16px 22px", border: "1px solid rgba(255,255,255,0.24)", borderRadius: 14, backgroundColor: "rgba(5,12,14,0.86)", color: "white", fontSize: 22, fontWeight: 760 }}>
        payment_account <span style={{ color: palette.green }}>· PII</span>
      </div>
    </FadeUp>
  </AbsoluteFill>
);
