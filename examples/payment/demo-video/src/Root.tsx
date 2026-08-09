import { Composition, Folder } from "remotion";
import { DemoVideo } from "./DemoVideo";
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
        <Composition id="Opening" component={OpeningScene} durationInFrames={620} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="DataHub" component={DataHubScene} durationInFrames={880} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Model" component={ModelScene} durationInFrames={840} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Generation" component={GenerationScene} durationInFrames={750} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Masking" component={MaskingScene} durationInFrames={1050} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="FailClosed" component={FailClosedScene} durationInFrames={760} fps={FPS} width={WIDTH} height={HEIGHT} />
        <Composition id="Closing" component={ClosingScene} durationInFrames={572} fps={FPS} width={WIDTH} height={HEIGHT} />
      </Folder>
    </>
  );
};
