
---

# 📘 Chapter 7: Conditional Statements in Java (If vs Switch)

## 🚀 1. What is Flow of Control?

### ✅ WHAT

**Flow of Control** defines the order in which statements execute in a program.

By default, Java executes code:

```java
Line 1 → Line 2 → Line 3 → ...
```

### ✅ WHY

Real-world problems are **not linear**. We need:

* Decision making (if condition)
* Repetition (loops)
* Jumps (break, continue)

So we control execution using **control flow statements**.

### ✅ TYPES OF FLOW CONTROL

1. **Selection (Decision Making)**

   * `if`, `if-else`, `switch`
2. **Iteration (Loops)**

   * `for`, `while`, `do-while`
3. **Jump Statements**

   * `break`, `continue`, `return`

---

# 🔀 2. Selection Statements (Decision Making)

## 🧠 Real-life Analogy

> You are going home and see two roads:

* If you have time → take long scenic route
* Else → take short route

👉 This is exactly what **if-else** does.

---

# 🔹 3. IF Statement

## ✅ WHAT

Executes a block **only if condition is TRUE**

```java
if (condition) {
    // code
}
```

## ✅ HOW it works

* Condition must return **boolean (true/false)**
* If `true` → block executes
* If `false` → skipped

## ✅ Example

```java
int i = 5;

if (i == 5) {
    System.out.println("i is 5");
}
```

---

## ⚠️ Important Concept: Boolean Expression

Condition must evaluate to:

```java
true or false
```

Examples:

```java
i == 5
i > 10
i < 20 && i > 5
```

---

# 🔸 4. IF-ELSE Statement

## ✅ WHAT

Provides **two choices**

```java
if (condition) {
    // if block
} else {
    // else block
}
```

## ✅ WHY

Ensures **exactly one path executes**

## ❌ Problem without else

```java
if (i == 5) {
    System.out.println("i is 5");
}
System.out.println("i is not 5");
```

👉 Both may print ❌

## ✅ Correct way

```java
if (i == 5) {
    System.out.println("i is 5");
} else {
    System.out.println("i is not 5");
}
```

---

# 🔢 5. Example: Even or Odd

```java
int i = 6;

if (i % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

👉 `%` = modulus operator (gives remainder)

---

# 🧩 6. Nested IF

## ✅ WHAT

An `if` inside another `if`

```java
if (i > 5) {
    if (i < 10) {
        System.out.println("Between 5 and 10");
    }
}
```

## ✅ HOW it works

* First condition checked
* Then inner condition checked

## ⚠️ Problem

❌ Hard to read
❌ Complex logic

## ✅ Better Alternative

```java
if (i > 5 && i < 10) {
    System.out.println("Between 5 and 10");
}
```

👉 Use logical operators instead of deep nesting

---

# 🪜 7. IF-ELSE-IF Ladder

## ✅ WHAT

Used when you have **multiple conditions**

```java
if (condition1) {
} else if (condition2) {
} else if (condition3) {
} else {
}
```

## ✅ HOW it works

* Checks from top to bottom
* Stops at first TRUE condition
* Remaining conditions are skipped

---

## 🎯 Example: Age Classification

```java
int age = 50;

if (age > 80) {
    System.out.println("Very Old");
} else if (age > 60) {
    System.out.println("Old");
} else if (age > 40) {
    System.out.println("Becoming Old");
} else if (age > 20) {
    System.out.println("Young");
} else {
    System.out.println("Child");
}
```

## 🧠 Key Insight

✔ Only **one block executes**
✔ Prevents multiple outputs

---

## ❌ Without Ladder (Wrong Approach)

```java
if (age > 40) {
    System.out.println("Becoming Old");
}
if (age > 20) {
    System.out.println("Young");
}
```

👉 Output:

```
Becoming Old
Young
```

❌ Logical mistake

---

# 🔄 8. Switch Statement

## ✅ WHAT

Alternative to `if-else-if ladder`
Used for **multiple fixed values**

---

## ✅ SYNTAX

```java
switch (variable) {
    case value1:
        // code
        break;

    case value2:
        // code
        break;

    case value3:
        // code
        break;

    default:
        // fallback
}
```

---

## 🧠 HOW it works

1. Variable is evaluated
2. Compared with each `case`
3. Matching case executes
4. `break` stops execution
5. If no match → `default`

---

## 🎯 Example

```java
int i = 3;

switch (i) {
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
        System.out.println("i is greater than 3");
}
```

---

# ⚠️ 9. Importance of `break`

## ❌ Without break (Fall-through)

```java
int i = 2;

switch (i) {
    case 1:
        System.out.println("1");
    case 2:
        System.out.println("2");
    case 3:
        System.out.println("3");
}
```

👉 Output:

```
2
3
```

❌ Problem: Execution continues

---

## ✅ With break

```java
case 2:
    System.out.println("2");
    break;
```

✔ Stops execution

---

# 🔁 10. Switch vs If-Else

| Feature     | If-Else                    | Switch                        |
| ----------- | -------------------------- | ----------------------------- |
| Conditions  | Complex (>, <, &&)         | Fixed values                  |
| Readability | Can be messy               | Clean for many cases          |
| Performance | Slower (sequential checks) | Faster (optimized internally) |
| Use case    | Dynamic logic              | Fixed options                 |

---

## 🧠 WHEN TO USE WHAT?

### ✅ Use `if-else` when:

* Conditions are complex
* Ranges are involved

```java
if (age > 18 && age < 60)
```

### ✅ Use `switch` when:

* Exact values
* Menu-based logic

```java
switch (day)
```

---

# 💡 11. Internal Insight (Important)

From transcript:

> Switch is more optimized than if-else ladder

### WHY?

* `if-else` → checks one by one
* `switch` → may use jump table / hashing internally

👉 Faster for large number of cases

---

# 🧹 12. Best Practices

✔ Always use `{}` (curly braces)
✔ Avoid deep nested if
✔ Prefer `switch` for multiple fixed values
✔ Use meaningful conditions
✔ Keep code readable

---

# 🧪 13. Practice Problems

1. Check if number is positive, negative, or zero
2. Grade system using if-else ladder
3. Menu-driven calculator using switch
4. Check leap year
5. Find largest of 3 numbers

---

# 🎯 Final Summary

* Control flow decides **how program executes**
* `if` → single condition
* `if-else` → two choices
* `if-else-if` → multiple conditions
* `switch` → optimized multi-case selection
* Always write **clean & readable logic**

---