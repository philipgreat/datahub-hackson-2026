import { Composition, Folder } from "remotion";
import { DemoVideo, sceneDurations } from "./DemoVideo";
import { FPS, HEIGHT, TOTAL_FRAMES, WIDTH } from "./constants";
import "./styles.css";
import { ClosingScene } from "./scenes/ClosingScene";
import { DataHubScene } from "./scenes/DataHubScene";
import { FailClosedScene } from "./scenes/FailClosedScene";
import { GenerationScene } from "./scenes/GenerationScene";
import { MaskingScene } from "./scenes/MaskingScene";
import { ModelScene } from "./scenes/ModelScene";
import { OpeningScene } from "./scenes/OpeningScene";

export const RemotionRoot: React.FC = () => {
  return (
    <>
      <Composition id="DataHubTeaQLDemo" component={DemoVideo} durationInFrames={TOTAL_FRAMES} fps={FPS} width={WIDTH} height={HEIGHT} />
      <Folder name="Scenes">
        <Composition id="Opening" component={OpeningScene} durationInFrames={sceneDurations.opening} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="DataHub" component={DataHubScene} durationInFrames={sceneDurations.dataHub} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Model" component={ModelScene} durationInFrames={sceneDurations.model} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Generation" component={GenerationScene} durationInFrames={sceneDurations.generation} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Masking" component={MaskingScene} durationInFrames={sceneDurations.masking} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="FailClosed" component={FailClosedScene} durationInFrames={sceneDurations.failClosed} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Closing" component={ClosingScene} durationInFrames={sceneDurations.closing} fps={FPS} width={WIDTH} height={HEIGHT} />
      </Folder>
    </>
  );
};
