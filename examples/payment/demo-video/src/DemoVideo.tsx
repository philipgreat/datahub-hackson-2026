import { TransitionSeries, linearTiming } from "@remotion/transitions";
import { fade } from "@remotion/transitions/fade";
import { AbsoluteFill } from "remotion";
import { CaptionOverlay } from "./components/CaptionOverlay";
import { TRANSITION_FRAMES } from "./constants";
import { ClosingScene } from "./scenes/ClosingScene";
import { DataHubScene } from "./scenes/DataHubScene";
import { FailClosedScene } from "./scenes/FailClosedScene";
import { GenerationScene } from "./scenes/GenerationScene";
import { MaskingScene } from "./scenes/MaskingScene";
import { ModelScene } from "./scenes/ModelScene";
import { OpeningScene } from "./scenes/OpeningScene";

const transition = linearTiming({ durationInFrames: TRANSITION_FRAMES });

export const DemoVideo: React.FC = () => (
  <AbsoluteFill>
    <TransitionSeries>
      <TransitionSeries.Sequence durationInFrames={620} name="Opening"><OpeningScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={880} name="DataHub source of truth"><DataHubScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={840} name="Context to model"><ModelScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={750} name="Local generation"><GenerationScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={1050} name="Java and Rust masking"><MaskingScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={760} name="Fail closed"><FailClosedScene /></TransitionSeries.Sequence>
      <TransitionSeries.Transition presentation={fade()} timing={transition} />
      <TransitionSeries.Sequence durationInFrames={572} name="Closing"><ClosingScene /></TransitionSeries.Sequence>
    </TransitionSeries>
    <CaptionOverlay />
  </AbsoluteFill>
);
