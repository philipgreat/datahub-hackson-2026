# DataHub × TeaQL Demo Video

A deterministic three-minute Remotion composition built from the committed payment evidence. The video is explicitly labeled `VERIFIED RUN REPLAY`: terminal output is a concise replay of real evidence, not a claim that commands execute during rendering.

## Preview

```bash
npm install
npm run studio
```

Open `DataHubTeaQLDemo`. Each scene is separately registered under `Scenes`.

## Render

```bash
npm run render
```

Output: `out/datahub-teaql-demo.mp4`.

The video is silent and uses burned-in English captions from `public/captions.json`. A voice-over can be added later without changing the scene structure.

Authoritative evidence remains in the parent `examples/payment` directory. Visuals use curated excerpts for legibility.

## Video specification

- Composition: `DataHubTeaQLDemo`
- Timeline: 5,400 frames at 30 FPS (180 seconds)
- Canvas: 1920 × 1080
- Output codec: H.264
- Scenes: seven independently previewable compositions
- Captions: burned-in English captions backed by Remotion `Caption` JSON

The DataHub scene uses a real screenshot captured from the evidence host through an SSH tunnel. The checked-in MP4 is the verified English render of the checked-in source.
