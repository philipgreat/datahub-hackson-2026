import type { PropsWithChildren } from "react";
import { Interactive } from "remotion";

export const FadeUp: React.FC<PropsWithChildren<{ delay?: number; name: string; style?: React.CSSProperties }>> = ({ name, style, children }) => (
  <Interactive.Div name={name} style={style}>{children}</Interactive.Div>
);
