
---

# Chapter - 7 — Selection Statements & Switch (Flow of Control)

> Structured notes from the lecture on **Flow of Control**, **if / if-else / if-else-if**, and **switch statements** in Java.

---

## 📌 What is Flow of Control?

Flow of Control simply means:

➡️ *In what order does your program execute statements?*

Normally, Java executes code **line by line (top to bottom)**.

But in real-world programs, we need **decision making**.

Example:

* If user is logged in → show dashboard
* Else → show login page

This is where **Selection Statements** come in.

---

## 🔹 Types of Flow Control (High Level)

In Java, flow of control is mainly of 3 types:

| Type      | Purpose                  |
| --------- | ------------------------ |
| Selection | Make decisions           |
| Iteration | Repeat actions (loops)   |
| Jump      | Break flow (break, etc.) |

In this lecture, we focus on:

➡️ **Selection Statements**

---

# 1️⃣ Selection Statements

Selection gives your program **multiple paths**.

Instead of straight execution:

```
Line 1 → Line 2 → Line 3
```

Now it becomes:

```
         ┌─ Do This
Check → ─┤
         └─ Do That
```

Main selection tools:

* `if`
* `if-else`
* `if-else-if ladder`
* `switch`

---

# 2️⃣ `if` Statement

## Syntax

```java
if (condition) {
    // execute if condition is true
}
```

Condition must evaluate to:

➡️ `true` OR `false`

---

## Example

```java
int i = 5;

if (i == 5) {
    System.out.println("i is 5");
}
```

If condition is **false**, Java skips the block.

---

# 3️⃣ `if-else`

Now we introduce **two choices**.

## Syntax

```java
if (condition) {
    // when true
} else {
    // when false
}
```

## Example

```java
int i = 6;

if (i == 5) {
    System.out.println("i is 5");
} else {
    System.out.println("i is not 5");
}
```

---

# 4️⃣ Example — Even or Odd

```java
int i = 6;

if (i % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

---

# 5️⃣ Nested `if`

You can place an `if` inside another `if`.

## Example

```java
int i = 8;

if (i > 5) {
    if (i < 10) {
        System.out.println("Between 6 and 9");
    }
}
```

⚠️ Avoid deep nesting (bad readability).

Better way:

```java
if (i > 5 && i < 10) {
    System.out.println("Between 6 and 9");
}
```

---

# 6️⃣ `if-else-if` Ladder

Used when there are **multiple mutually exclusive conditions**.

## Example — Age Category

```java
int age = 50;

if (age > 80) {
    System.out.println("Very old");
} 
else if (age > 60) {
    System.out.println("Old");
}
else if (age > 40) {
    System.out.println("Becoming old");
}
else if (age > 20) {
    System.out.println("Young");
}
else {
    System.out.println("Child");
}
```

✅ Once a condition becomes true → remaining checks are skipped.

---

# 7️⃣ Independent `if` vs Ladder

❌ Bad:

```java
if (age > 40) System.out.println("Becoming old");
if (age > 20) System.out.println("Young");
```

Both may run.

✅ Ladder ensures only ONE path runs.

---

# 8️⃣ Switch Statement

Used when checking **multiple values of the same variable**.

Instead of:

```java
if(i == 1)
else if(i == 2)
else if(i == 3)
```

We can write:

```java
switch(i) {
    case 1:
        System.out.println("i is 1");
        break;
    case 2:
        System.out.println("i is 2");
        break;
    case 3:
        System.out.println("i is 3");
        break;
    default:
        System.out.println("i > 3");
}
```

---

# 9️⃣ How Switch Works

```java
int i = 3;
```

Java checks:

* case 1 ❌
* case 2 ❌
* case 3 ✅ → executes

---

# 🔑 Role of `break`

Without break:

```java
int i = 1;

switch(i) {
    case 1:
        System.out.println("1");
    case 2:
        System.out.println("2");
    case 3:
        System.out.println("3");
}
```

Output:

```
1
2
3
```

➡️ This is called **fall-through**.

Break stops execution from flowing into next case.

---

# 🔟 Default Case

Acts like final `else`.

```java
default:
    System.out.println("No match");
```

---

# 1️⃣1️⃣ Switch vs If-Else

| Feature           | Switch               | If-Else |
| ----------------- | -------------------- | ------- |
| Equality check    | ✅ Yes                | ✅ Yes   |
| Range check (> <) | ❌ No                 | ✅ Yes   |
| Complex logic     | ❌ No                 | ✅ Yes   |
| Performance       | ⚡ Faster (sometimes) | Slower  |
| Boolean support   | ❌ No                 | ✅ Yes   |

---

# 1️⃣2️⃣ Why Switch Can Be Faster?

Internally JVM may use:

### ➜ Jump Tables

Instead of checking:

```
1 → 2 → 3 → 4
```

It jumps directly to the correct case.

So:

| Structure             | Time Complexity |
| --------------------- | --------------- |
| if-else ladder        | O(n)            |
| switch (dense cases)  | O(1)            |
| switch (sparse cases) | O(log n)        |

---

# 1️⃣3️⃣ Switch Limitations

Switch works only on:

* `byte`
* `short`
* `int`
* `char`
* `String` (JDK 7+)
* `enum`

❌ Cannot switch on:

```java
switch(i > 5) // ERROR (boolean)
```

---

# 1️⃣4️⃣ Nested Switch

Switch inside switch is allowed.

```java
int j = 5;

switch(j) {
    case 5:
        int k = 1;
        switch(k) {
            case 1:
                System.out.println("Nested switch");
        }
}
```

---

# 1️⃣5️⃣ Best Practices

✅ Use `if` for:

* ranges
* complex logic
* boolean checks

✅ Use `switch` for:

* menu systems
* enums
* constant value matching

⚠️ Always use `break` unless fall-through is intended.

---

# 🧪 Practice Questions

1. Check positive / negative / zero using `if-else`
2. Grade system using ladder
3. Menu system using switch
4. Weekday finder using switch
5. Nested switch example

---

# 📌 Summary

| Concept    | Purpose                    |
| ---------- | -------------------------- |
| if         | One condition              |
| if-else    | Two choices                |
| if-else-if | Multiple choices           |
| nested if  | Condition inside condition |
| switch     | Multi-value equality check |
| break      | Stops fall-through         |
| default    | Final fallback             |

---