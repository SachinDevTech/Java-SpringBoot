# Chapter 6 — Operators in Java

## Table of contents

* [Overview](#overview)
* [Arithmetic operators](#arithmetic-operators)
* [Assignment and compound assignment](#assignment-and-compound-assignment)
* [Increment / Decrement (prefix vs postfix)](#increment--decrement-prefix-vs-postfix)
* [Relational operators](#relational-operators)
* [Logical operators & short-circuiting](#logical-operators--short-circuiting)
* [Bitwise operators (AND, OR, XOR, NOT)](#bitwise-operators-and-or-xor-not)
* [Shift operators (<<, >>, >>>)](#shift-operators-ll--r---)
* [Ternary (conditional) operator](#ternary-conditional-operator)
* [Operator precedence & associativity](#operator-precedence--associativity)
* [Best practices & gotchas](#best-practices--gotchas)
* [Helpful examples (copy & run)](#helpful-examples-copy--run)

---

## Overview

Operators are the building blocks that let you perform calculations, comparisons, bit manipulations and control logic in Java. This chapter groups operators by *purpose* so you can learn when to use each, and — importantly — what outputs (types) they produce.

Key takeaways:

* Arithmetic operators produce numeric results.
* Relational operators produce boolean results (`true` / `false`).
* Logical operators combine boolean expressions and can short-circuit.
* Bitwise and shift operators operate on binary representation (bits) and usually act on `int`/`long` (smaller types are promoted).
* Assignment can be chained and compound forms exist (`+=`, `&=`, `<<=` etc.).

---

## Arithmetic operators

Operators: `+`, `-`, `*`, `/`, `%` (modulus)

* Work on numeric operands (byte/short/int/long/float/double).
* Division `/` between integers produces integer division (fraction discarded). Use casts for floating point division.

```java
int a = 5;
int b = 10;
int sum = a + b;       // 15
int diff = a - b;      // -5
int prod = a * b;      // 50
int quot = b / a;      // 2 (integer division)
int rem  = b % a;      // 0 (remainder)

// Use casting for floating division
double d = (double)b / a; // 2.0
```

---

## Assignment and compound assignment

* Simple assignment: `=` — assigns right-hand value to left-hand variable.

```java
int x = 10; // assigns 10 to x
```

* Chaining assignments allowed: `int a = b = c = 10;` — rightmost assigned first.

* Compound assignment combines an operator with `=` and performs the operation + assignment with implicit cast: `+=, -=, *=, /=, %=, &=, |=, ^=, <<=, >>=, >>>=`

```java
int h = 5;
h += 2; // equivalent to h = h + 2
h *= 3; // equivalent to h = h * 3

byte by = 1;
by = (byte)(by << 1); // explicit cast required for shifts
// but using compound assignment automatically casts back:
by <<= 1; // compiles (implicit cast)
```

> Note: compound assignment does an implicit cast to the left variable's type (but plain `=` with an expression that yields a larger type may require an explicit cast).

---

## Increment / Decrement — `++` / `--`

Two forms:

* **Postfix**: `i++` (use the value, then increment)
* **Prefix** : `++i` (increment first, then use the value)

```java
int i = 6;
System.out.println(i);  // 6
System.out.println(i++); // prints 6, then i becomes 7
System.out.println(i);  // 7

int j = 6;
System.out.println(++j); // prints 7, j is 7
```

Important when used inside expressions — prefix vs postfix changes the value used in assignment and expression evaluation.

---

## Relational operators

Operators: `==`, `!=`, `<`, `>`, `<=`, `>=`

* Compare two operands and return boolean (`true` / `false`).
* Used heavily in conditions (`if`, `while`, `for`).

```java
int a = 5, b = 10;
boolean eq = (a == b);    // false
boolean ne = (a != b);    // true
boolean lt = (a < b);     // true
boolean ge = (a >= 5);    // true
```

> Note: for objects use `.equals()` for logical equality (unless you explicitly want identity with `==`).

---

## Logical operators & short-circuiting

Operators: `&&` (AND), `||` (OR), `!` (NOT)

These operate on boolean expressions (not on bit-level). They also implement **short-circuit** evaluation:

* `expr1 && expr2`: if `expr1` is `false`, `expr2` is not evaluated — overall result is `false`.
* `expr1 || expr2`: if `expr1` is `true`, `expr2` is not evaluated — overall result is `true`.

Short-circuiting is useful for safe checks like `obj != null && obj.method()` to avoid `NullPointerException`.

```java
boolean r = (5 < 10) && (10 < 15); // true

// short-circuit example:
String s = null;
if (s != null && s.length() > 0) { // safe — second operand not evaluated when s==null
    // ...
}
```

**Caveat:** Bitwise operators `&` and `|` (single ampersand/pipe) can be used between boolean expressions as non-short-circuit logical ops — they always evaluate both sides.

```java
boolean a = false;
boolean b = someFunction();
// using & will call someFunction() regardless of a's value
boolean result = a & b; // no short-circuit
```

This is rarely used for boolean logic in application code, but useful when you intentionally want both sides evaluated.

---

## Bitwise operators (AND `&`, OR `|`, XOR `^`, NOT `~`)

* Work on the binary representation of integer types (`int`/`long` most commonly).
* Byte/short/char operands are promoted to `int` before the operation.

Truth table (bit-level):

| A | B | A & B | A | B | A ^ B |
|---:|---:|:-----:|:-----:|:-----:|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 | 1 |
| 1 | 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 | 0 |

* `&` — bitwise AND
* `|` — bitwise OR
* `^` — bitwise XOR (1 if bits differ)
* `~` — bitwise NOT (invert all bits)

Example:

```java
int a = 2; // ...00010
int b = 3; // ...00011
System.out.println(a & b); // 2 (...00010)
System.out.println(a | b); // 3 (...00011)
System.out.println(a ^ b); // 1 (...00001)
System.out.println(~a);    // bitwise not -> large negative number (two's complement)
```

**Important:** `~a` converts to negative numbers for signed types — be mindful when converting back to smaller types (truncation).

---

## Shift operators: `<<`, `>>`, `>>>`

Shifts move bits left or right. Useful for fast multiplications/divisions by powers of two and for bit-manipulation.

* `<<` : left shift — shifts bits to left, fills rightmost with `0`. Equivalent to multiplication by 2 for positive ints (subject to overflow).
* `>>` : arithmetic right shift — shifts bits to right, sign-extends (fills left with sign bit) — preserves sign for negative numbers.
* `>>>`: logical right shift — shifts bits to right, fills left with `0` (no sign extension). Only exists for integer types in Java.

### Key rules & gotchas

1. **Type promotion**: shift operations are performed on `int` or `long`. If you shift a `byte` or `short`, Java will promote it to `int` first, then shift, and result is `int`. Assigning back to `byte` requires explicit cast or compound assignment.
2. **Truncation when assigning back**: If you `byte b = (byte) (b << 1);`, the result is truncated to 8 bits — so you are seeing only the low 8 bits after shifts.
3. **Shift amount is masked**: shifting an `int` by `n` uses `n & 0x1f` (i.e. `n % 32`) — you can only meaningfully shift 0..31 for `int`. For `long`, the mask is `0x3f` (0..63).

Examples:

```java
int v = 8;      // 00001000
System.out.println(v << 1); // 16
System.out.println(v << 2); // 32

int i = 1;
System.out.println(i << 30); // biggest positive power-of-two that fits without sign change
System.out.println(i << 31); // becomes negative (MSB set)
System.out.println(i << 32); // equivalent to i << 0 -> 1 (because 32 % 32 == 0)

// right shifts
int n = -128;
System.out.println(n >> 1);  // sign-extending: remains negative
System.out.println(n >>> 1); // logical shift: introduces 0s at left, changes sign
```

Use `>>>` when you need unsigned logical shifting (e.g. when working with raw binary data / pixels).

---

## Ternary (conditional) operator: `?:`

A compact if-else that returns a value:

```java
int a = 10;
String result = (a % 2 == 0) ? "even" : "odd";
```

Equivalent to:

```java
String result;
if (a % 2 == 0) result = "even"; else result = "odd";
```

Ternary operator has three operands: condition, value-if-true, value-if-false. Useful for concise assignments.

---

## Operator precedence & associativity (summary)

* Parentheses `()` — highest precedence (use them to make expressions explicit)
* Postfix (`expr++`, `expr--`) — high
* Prefix and unary (`++expr`, `--expr`, `+`, `-`, `!`, `~`) — next
* Multiplicative (`*`, `/`, `%`) — next
* Additive (`+`, `-`) — next
* Shifts (`<<`, `>>`, `>>>`) — next
* Relational (`<`, `>`, `<=`, `>=`) — next
* Equality (`==`, `!=`) — next
* Bitwise AND `&`, XOR `^`, OR `|` — next group
* Logical `&&`, `||` — lower precedence than bitwise
* Ternary `?:` — lower
* Assignment `=`, `+=`, `-=` ... — right-associative (evaluated last)

**Tip:** Don’t memorize everything — use parentheses to document & control order of evaluation.

---

## Best practices & gotchas

* Prefer `&&` / `||` for boolean logic. Only use `&` / `|` for boolean when you intentionally want both sides evaluated.
* Remember integer division semantics: cast to `double` for floating division.
* Be mindful of **type promotion**: `byte`/`short/char` promote to `int` in expressions.
* When using bitwise/shift operations on small types, remember the operation happens on `int` and final result may be truncated.
* Use parentheses liberally to make complex expressions readable and to avoid subtle precedence bugs.
* When working with bit-level algorithms (hashing, masking, bitfields), prefer `int`/`long` and document the bit layout.
* For loops and counters, prefer `++i`/`i++` as appropriate. In modern Java the performance difference is negligible for primitives, but readability matters.

---

## Helpful examples (copy & run)

Save the following into a `OperatorsDemo.java` file and run to experiment.

```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 5, b = 10;

        // Arithmetic
        System.out.println("a + b = " + (a + b));
        System.out.println("b / a (int) = " + (b / a));
        System.out.println("(double)b / a = " + ((double)b / a));

        // Compound assignment
        int h = 5;
        h += 2; // 7
        System.out.println("h after +=2: " + h);

        // Prefix vs Postfix
        int i = 6;
        System.out.println("i before: " + i);
        System.out.println("i++ (post): " + (i++)); // prints 6, i becomes 7
        System.out.println("++i (pre): " + (++i)); // increments then prints 8

        // Relational
        System.out.println("a == b? " + (a == b));
        System.out.println("a != b? " + (a != b));

        // Logical & short-circuit
        String s = null;
        boolean safe = (s != null) && (s.length() > 0); // safe due to short-circuit
        System.out.println("safe check: " + safe);

        // Bitwise
        System.out.println("2 & 3 = " + (2 & 3));
        System.out.println("2 | 3 = " + (2 | 3));
        System.out.println("2 ^ 3 = " + (2 ^ 3));
        System.out.println("~2 = " + (~2));

        // Shift
        int v = 8;
        System.out.println("8 << 1 = " + (v << 1)); // 16
        System.out.println("8 >> 1 = " + (v >> 1)); // 4
        System.out.println("-128 >> 1 = " + (-128 >> 1));
        System.out.println("-128 >>> 1 = " + (-128 >>> 1));

        // Ternary
        System.out.println((a % 2 == 0) ? "even" : "odd");

        // Compound with byte and explicit cast
        byte by = 1;
        by <<= 1; // compiles: 1 -> 2
        System.out.println("byte after <<=1: " + by);

        // Demonstrate shift masking
        int g = 1;
        System.out.println("g << 31 = " + (g << 31));
        System.out.println("g << 32 (equivalent to g << 0) = " + (g << 32));
    }
}
```

---

## Git / publishing suggestions

* Suggested filename: `Chapter-06-Operators.md` or `operators.md` inside `java-basics/`.
* Suggested commit message: `docs: add Chapter 6 - Operators in Java (README)`
* Add a small license (MIT) and README at repo root for open-source contribution.

---

### Final notes

This document focuses on clarity, examples, and practical gotchas (type promotion, truncation, short-circuit). Use the examples as interactive exercises — modify values, run, and observe results. If you'd like, I can:

* produce a ready-to-commit `README.md` with front-matter,
* add more interactive exercises and quiz questions,
* or produce small diagrams (bit-layout illustrations) to embed.

Happy coding ✨
