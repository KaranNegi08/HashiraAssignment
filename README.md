
# Hashira Placements Assignment - Online

**Duration:** 45 mins  
**Language:** Any language except Python  

## Problem Statement
You are given a JSON file containing roots of a polynomial in different number bases.  
Your task:
1. Read the JSON input.
2. Convert all `"value"` fields to decimal using their `"base"`.
3. Use first `k` roots (where `k = m + 1`, m = degree of polynomial) to compute coefficients.
4. Print the polynomial coefficients.

---

## Sample Input (testcase1.json)

```json
{
    "keys": { "n": 4, "k": 3 },
    "1": { "base": "10", "value": "4" },
    "2": { "base": "2", "value": "111" },
    "3": { "base": "10", "value": "12" },
    "6": { "base": "4", "value": "213" }
}
