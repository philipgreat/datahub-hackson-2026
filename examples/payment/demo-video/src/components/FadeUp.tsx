import type { PropsWithChildren } from "react";
import { Easing, Interactive, interpolate, useCurrentFrame } from "remotion";

export const FadeUp: React.FC<PropsWithChildren<{ delay?: number; name: string; style?: React.CSSProperties }>> = ({ delay = 0, name, style, children }) => {
  const frame = useCurrentFrame();
  return (
    <Interactive.Div name={name} style={{
      ...style,
      opacity: interpolate(frame, [delay, delay + 24], [0, 1], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(0.16, 1, 0.3, 1) }),
      transform: `translateY(${interpolate(frame, [delay, delay + 24], [30, 0], { extrapolateLeft: "clamp", extrapolateRight: "clamp", easing: Easing.bezier(0.16, 1, 0.3, 1) })}px)`,
    }}>{children}</Interactive.Div>
  );
};
