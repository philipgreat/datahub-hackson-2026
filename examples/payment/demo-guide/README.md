# Demo Director

This local-only page guides the three-minute DataHub × TeaQL demonstration.

From the repository root on the evidence host:

```bash
python3 -m http.server 4173 --bind 127.0.0.1
```

Forward both the director page and DataHub UI from the operator machine:

```bash
ssh \
  -L 4173:127.0.0.1:4173 \
  -L 9002:127.0.0.1:9002 \
  -p 56022 \
  philip@iot.doublechaintech.com
```

Open:

```text
http://localhost:4173/examples/payment/demo-guide/
```

Keyboard controls:

- `Space` or `→`: next step
- `←`: previous step
- `1` through `7`: jump to a step
- `F`: toggle caption mode

All evidence links open in a separate browser tab. The page does not contain credentials or private tokens.
