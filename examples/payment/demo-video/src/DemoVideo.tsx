import { AbsoluteFill, Series } from "remotion";
import { CaptionOverlay } from "./components/CaptionOverlay";
import { ClosingScene } from "./scenes/ClosingScene";
import { DataHubScene } from "./scenes/DataHubScene";
import { FailClosedScene } from "./scenes/FailClosedScene";
import { GenerationScene } from "./scenes/GenerationScene";
import { MaskingScene } from "./scenes/MaskingScene";
import { ModelScene } from "./scenes/ModelScene";
import { OpeningScene } from "./scenes/OpeningScene";

export const sceneDurations = {
  opening: 270,
  dataHub: 360,
  model: 360,
  generation: 390,
  masking: 480,
  failClosed: 390,
  closing: 450,
} as const;

export const DemoVideo: React.FC = () => (
  <AbsoluteFill>
    <Series>
      <Series.Sequence durationInFrames={sceneDurations.opening} name="Opening"><OpeningScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.dataHub} name="DataHub source of truth"><DataHubScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.model} name="Context to model"><ModelScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.generation} name="Local generation"><GenerationScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.masking} name="Java and Rust masking"><MaskingScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.failClosed} name="Fail closed"><FailClosedScene /></Series.Sequence>
      <Series.Sequence durationInFrames={sceneDurations.closing} name="Closing"><ClosingScene /></Series.Sequence>
    </Series>
    <CaptionOverlay />
  </AbsoluteFill>
);
