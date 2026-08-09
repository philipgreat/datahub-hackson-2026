export type TerminalLine = {
  text: string;
  at: number;
  tone?: "command" | "output" | "success" | "muted" | "error";
};
