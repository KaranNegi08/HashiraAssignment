const fs = require("fs");

function baseToDecimal(value, base) {
  return BigInt(parseInt(value, base));
}

function computeCFromJson(filePath) {
  const data = JSON.parse(fs.readFileSync(filePath, "utf8"));
  const k = data.keys.k; 
  const points = [];
  for (const key of Object.keys(data)) {
    if (key === "keys") continue;
    const x = BigInt(key);
    const base = parseInt(data[key].base);
    const y = baseToDecimal(data[key].value, base);
    points.push({ x, y });
  }

  const selected = points.slice(0, k);

  const roots = selected.map(p => Number(p.y));

  let product = 1;
  for (const r of roots) product *= r;
  const c = ((-1) ** k) * product;

  console.log("Computed c =", c);
  return c;
}

computeCFromJson("data.json");
