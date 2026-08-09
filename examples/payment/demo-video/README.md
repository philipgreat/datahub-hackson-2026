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

The first version is silent and uses burned-in Chinese captions from `public/captions.json`. A voice-over can be added later without changing the scene structure.

Authoritative evidence remains in the parent `examples/payment` directory. Visuals use curated excerpts for legibility.

## Video specification

- Composition: `DataHubTeaQLDemo`
- Timeline: 5,400 frames at 30 FPS (180 seconds)
- Canvas: 1920 × 1080
- Output codec: H.264
- Scenes: seven independently previewable compositions
- Captions: burned-in Chinese captions backed by Remotion `Caption` JSON

The checked-in MP4 is the verified render of the checked-in source. Replace the reconstructed DataHub scene with captured UI footage later if desired; the scene boundary and timing can remain unchanged.
