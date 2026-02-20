# 📘 Chapter 5 — Type Conversion in Java

---

# 🚀 What is Type Conversion?

Type Conversion = Converting one data type into another.

Example:

```java
byte → int
int → long
float → int
char → int
```

Why needed?

Because different variables have different memory sizes.

| Type   | Size   |
| ------ | ------ |
| byte   | 8-bit  |
| short  | 16-bit |
| char   | 16-bit |
| int    | 32-bit |
| long   | 64-bit |
| float  | 32-bit |
| double | 64-bit |

---

# 🔥 Types of Type Conversion

There are **3 main types**:

1. Implicit Conversion (Automatic)
2. Explicit Conversion (Manual / Casting)
3. Truncation Conversion (Decimal Loss)

---

# 🟢 1. Implicit Conversion (Widening)

👉 Done automatically by Java
👉 Happens when destination type is **bigger**

### Rule:

> Destination type must be wider than source type

---

## Example

```java
byte b = 24;
int i = b;
```

Works because:

```
byte (8-bit) → int (32-bit)
```

No data loss possible ✔

---

## Concept Flow

```
Small Type → Bigger Type → Safe → Automatic
```

Examples:

| From  | To     |
| ----- | ------ |
| byte  | short  |
| short | int    |
| int   | long   |
| char  | int    |
| int   | double |

---

## Character to Integer

Characters are internally stored as numbers (Unicode).

```java
char c = 'A';
int i = c;
System.out.println(i);
```

Output:

```
65
```

Because:

```
'A' → Unicode → 65
```

---

# 🔴 2. Explicit Conversion (Narrowing)

👉 Done manually
👉 Needed when destination type is **smaller**

Java doesn't do this automatically because:

⚠ Data may be lost

---

## Example

```java
int i = 300;
byte b = (byte) i;
System.out.println(b);
```

Output:

```
44
```

---

## Why 44?

byte range:

```
-128 to 127
```

300 is outside range.

So Java keeps only last 8 bits.

Shortcut formula:

```
b = i % 256
b = 300 % 256
b = 44
```

---

## Concept Flow

```
Big Type → Small Type → Data Loss Possible → Needs Casting
```

---

## More Examples

```java
long l = 50000;
int i = (int) l;
```

```java
double d = 10.75;
float f = (float) d;
```

---

# ✂ 3. Truncation Conversion

Occurs when:

```
float/double → int
```

Decimal part gets removed (not rounded)

---

## Example

```java
float f = 15.99f;
int i = (int) f;
System.out.println(i);
```

Output:

```
15
```

Decimal is truncated ❌ not rounded.

---

# 🚫 Boolean Conversion Not Allowed

Java does NOT allow conversion between:

```
boolean ↔ any number type
```

Example:

```java
boolean flag = true;
int i = (int) flag;   // ❌ Error
```

Reason:

Boolean is logical value, not numeric.

---

# ⚡ Automatic Type Promotion

Happens during expressions.

Java promotes smaller types before calculation.

---

## Rule 1

```
byte, short, char → promoted to int
```

Example:

```java
byte a = 50;
byte b = 40;
byte c = (byte)(a * b);
```

Why casting needed?

Because:

```
a * b → promoted to int
50 * 40 = 2000 → int
int → byte needs casting
```

---

## Rule 2

If one operand is:

| Type Present | Expression Becomes |
| ------------ | ------------------ |
| long         | long               |
| float        | float              |
| double       | double             |

---

## Example 1

```java
int i = 10;
float f = 5.5f;
float result = i + f;
```

Expression becomes float.

---

## Example 2

```java
double d = 10.2;
int i = 5;
double result = d * i;
```

Expression becomes double.

---

## Example 3

```java
long l = 100;
int i = 20;
long result = l + i;
```

Expression becomes long.

---

# 📌 Promotion Hierarchy

```
byte
short
char
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Entire expression moves to highest type present.

---

# 🔎 Special Case

```java
byte b = 50;
b = b * 2;
```

Error ❌

Because:

```
b * 2 → promoted to int
int → cannot assign to byte
```

Correct:

```java
b = (byte)(b * 2);
```

---

# 🧠 Expression Example

```java
byte b = 5;
char c = 'A';
short s = 10;
int i = 20;
float f = 2.5f;
double d = 3.5;

double result = f*b + i/c - d*s;
```

Evaluation Flow:

```
f*b → float
i/c → int
d*s → double

float + int → float
float - double → double
```

Final result → double

---

# 🎯 Interview Takeaways

✔ Implicit = Widening
✔ Explicit = Narrowing
✔ Float → Int = Truncation
✔ Boolean cannot convert
✔ Expressions auto-promote
✔ byte/short/char become int in operations
✔ Result type = largest type in expression

---

# 🏁 Quick Summary

| Conversion    | Automatic? | Safe? |
| ------------- | ---------- | ----- |
| byte → int    | ✔          | ✔     |
| int → byte    | ❌          | ❌     |
| float → int   | ❌          | ❌     |
| char → int    | ✔          | ✔     |
| boolean → int | ❌          | ❌     |

---

# 📌 Golden Rule

> In expressions, Java always upgrades to the biggest type before calculating.