# 📘 Chapter 4 — Binary Representation of Negative & Floating Point Numbers (Java Internal Working)

---

# 🚀 Why This Topic Matters

Computers **do NOT understand:**

* Negative numbers ❌
* Decimal numbers ❌

They ONLY understand:

```
0 and 1
```

So the big question is:

👉 How are

* `-42`
* `0.7`
* `8.125`

stored in memory?

This chapter explains:

✔ Negative number storage
✔ Floating point precision issue
✔ Why `0.7 != 0.7` internally
✔ IEEE-754 format
✔ Interview-ready logic

---

# 🧠 Part 1 — How Negative Numbers are Stored

Computers use:

> 🔹 **Two’s Complement Representation**

---

## Step 1 — Example: Store `-42` in 8-bit (byte)

### Step A — Convert +42 to binary

```
42 = 00101010
```

---

### Step B — Find 1’s Complement (Flip bits)

```
00101010  →  11010101
```

---

### Step C — Add 1 (2’s Complement)

```
11010101
+       1
---------
11010110
```

✔ This is what gets stored in memory

```
-42 stored as → 11010110
```

---

# 🔎 How Computer Knows It's Negative?

Check **MSB (Most Significant Bit)**

| MSB | Meaning  |
| --- | -------- |
| 0   | Positive |
| 1   | Negative |

Here:

```
11010110 → MSB = 1 → Negative
```

---

# 🔄 How Retrieval Works

When printing:

1. Detect MSB = 1 → Negative
2. Take 2’s complement again

```
11010110
→ 1’s complement → 00101001
→ +1 → 00101010 = 42
```

Attach negative sign:

```
= -42
```

---

# ❓ Why NOT 1’s Complement Only?

Because of **Negative Zero Problem**

---

## Problem:

If using 1’s complement:

```
0  = 00000000
-0 = 11111111 ❌
```

Two zeros exist → ❌ WRONG

---

## Solution → Use 2’s Complement

```
11111111 + 1 = 1 00000000
```

Ignore overflow bit → store:

```
00000000 → Only one zero ✔
```

---

# 🎯 Final Logic — Why Two’s Complement?

✔ Removes negative zero
✔ Simplifies arithmetic
✔ Enables MSB sign detection
✔ Standardized across hardware

---

# 🧠 Part 2 — Floating Point Storage

Example:

```java
float f = 8.125f;
float g = 0.7f;
```

Both stored differently internally.

---

# 🧱 Float Memory Layout (32-bit)

IEEE-754 Standard

| Bits | Purpose  |
| ---- | -------- |
| 1    | Sign     |
| 8    | Exponent |
| 23   | Mantissa |

```
| Sign | Exponent | Mantissa |
|  1   |    8     |   23     |
```

---

# 🧮 Step-by-Step Storage Example

## Example → Store `8.125`

---

## Step 1 — Convert to Binary

Integer:

```
8 = 1000
```

Fraction:

Multiply repeatedly by 2:

```
0.125 × 2 = 0.25 → 0
0.25 × 2 = 0.5 → 0
0.5 × 2 = 1.0 → 1
```

So:

```
8.125 = 1000.001₂
```

---

## Step 2 — Normalize

Move decimal:

```
1000.001 = 1.000001 × 2³
```

---

## Step 3 — Apply Bias

Float bias = **127**

```
Exponent = 3 + 127 = 130
130 → 10000010
```

---

## Step 4 — Fill IEEE Format

### Sign bit

```
Positive → 0
```

---

### Exponent

```
10000010
```

---

### Mantissa

Drop leading 1:

```
000001
```

Fill remaining bits with zeros.

---

## Final Memory Representation

```
0 | 10000010 | 00000100000000000000000
```

---

# 🔄 Retrieval Formula

To reconstruct value:

[
(-1)^{sign} × (1 + mantissa) × 2^{(exponent - bias)}
]

Works perfectly for:

```
8.125 ✔ Exact
```

---

# ⚠️ Part 3 — Why 0.7 Causes Problems

Try:

```java
System.out.printf("%.20f", 0.7f);
```

Output:

```
0.69999998807907104492
```

---

# ❗ Why?

Convert 0.7 to binary:

Multiply by 2 repeatedly:

```
0.7 × 2 = 1.4 → 1
0.4 × 2 = 0.8 → 0
0.8 × 2 = 1.6 → 1
0.6 × 2 = 1.2 → 1
0.2 × 2 = 0.4 → 0
```

Pattern repeats:

```
0.7 = 0.101100110011... (infinite)
```

---

# 🚨 Problem

Float only has **23 mantissa bits**

So it stores:

```
Truncated approximation
```

Hence:

```
Stored ≠ Exact
Retrieved ≈ Close value
```

So:

```
0.7 → 0.6999999...
```

Java hides this via rounding in `println()`.

---

# 📌 Core Insight

Some decimals:

| Decimal | Binary     |
| ------- | ---------- |
| 0.5     | Exact      |
| 0.25    | Exact      |
| 0.125   | Exact      |
| 0.7     | Infinite ❌ |

Only fractions of powers of 2 are exact.

---

# 🧠 Part 4 — Bias Concept

Why bias?

Because exponent can be negative.

Example:

```
0.7 normalized = 1.x × 2⁻¹
```

Computers prefer unsigned storage.

So:

```
Store = -1 + 127 = 126
```

---

# 📌 Bias Formula

[
Bias = 2^{(k-1)} - 1
]

For float:

```
k = 8 bits
Bias = 2⁷ - 1 = 127
```

---

# 🧠 Part 5 — Double Representation

| Type   | Bits | Sign | Exponent | Mantissa |
| ------ | ---- | ---- | -------- | -------- |
| Float  | 32   | 1    | 8        | 23       |
| Double | 64   | 1    | 11       | 52       |

Bias for double:

[
2^{10} - 1 = 1023
]

Still:

❌ Cannot store 0.7 exactly

Only **more precise approximation**

---

# 🎯 Final Interview Takeaways

✔ Negative numbers → Two’s Complement
✔ MSB decides sign
✔ Floating numbers → IEEE-754
✔ Some decimals cannot be stored exactly
✔ Precision loss happens due to limited mantissa
✔ Bias avoids negative exponent storage

---

# 🧩 Practical Fix

Use:

```java
BigDecimal
```

When exact decimal precision is needed.

Example:

Financial systems
Scientific calculations

---

# 🏁 Summary Flow

```
Negative Numbers
→ Convert positive to binary
→ 1's complement
→ +1 → store

Floating Numbers
→ Convert to binary
→ Normalize
→ Add bias
→ Store sign, exponent, mantissa

Precision Issue
→ Some decimals infinite in binary
→ Truncation happens
→ Approximate storage
```

---

# 🔥 You Now Understand

What most developers don’t:

👉 How numbers ACTUALLY live inside memory