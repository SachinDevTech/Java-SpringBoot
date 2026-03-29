
---

# 🔁 Chapter 8: Loops in Java (Iteration Statements)


# 🚀 1. What are Loops?

## ✅ WHAT

Loops are **iteration statements** that allow a block of code to execute **multiple times**.

```java
Repeat → Repeat → Repeat → Stop
```

---

## ✅ WHY

Without loops, repetitive tasks become inefficient:

❌ Without loops:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
// ... up to 100
```

✔ With loops:

```java
for (int i = 1; i <= 100; i++) {
    System.out.println(i);
}
```

👉 Cleaner, scalable, maintainable

---

## 🧠 Core Idea

> “Execute a block of code repeatedly until a condition becomes false”

---

# 🔄 2. Types of Loops in Java

1. **while loop**
2. **do-while loop**
3. **for loop**

---

# 🔹 3. WHILE Loop

## ✅ WHAT

Executes code **while condition is true**

---

## ✅ SYNTAX

```java
while (condition) {
    // code
}
```

---

## ✅ HOW it works

1. Check condition
2. If TRUE → execute block
3. Repeat
4. Stop when FALSE

---

## 🎯 Example: Print 1 to 10

```java
int i = 1;

while (i <= 10) {
    System.out.println(i);
    i++;
}
```

---

## ⚠️ Infinite Loop Problem

```java
int i = 1;

while (i <= 10) {
    System.out.println(i);
}
```

❌ Output: Infinite loop
👉 Because `i` never changes

---

## 🧠 Key Rule

> Always ensure **loop condition eventually becomes false**

---

## 🔁 Reverse Loop

```java
int i = 10;

while (i >= 1) {
    System.out.println(i);
    i--;
}
```

---

## ⚠️ Curly Braces Rule

```java
while (i <= 10)
    System.out.println(i);
```

✔ Works (single statement)

❗ But best practice:

```java
while (i <= 10) {
    System.out.println(i);
}
```

---

# 🔸 4. DO-WHILE Loop

## ✅ WHAT

Executes block **at least once**, then checks condition

---

## ✅ SYNTAX

```java
do {
    // code
} while (condition);
```

---

## 🔁 HOW it works

1. Execute block FIRST
2. Check condition
3. Repeat if TRUE

---

## 🎯 Example

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 10);
```

---

## 🔥 Key Difference

| Feature           | while   | do-while |
| ----------------- | ------- | -------- |
| Condition check   | Before  | After    |
| Minimum execution | 0 times | 1 time   |

---

## ⚠️ Important Case

```java
int i = 11;

while (i <= 10) {
    System.out.println(i);
}
```

👉 Output: ❌ Nothing

```java
do {
    System.out.println(i);
} while (i <= 10);
```

👉 Output:

```
11
```

✔ Executes once

---

## 🎮 Real Use Case: Menu System

```java
do {
    System.out.println("1. Play Game");
    System.out.println("2. Load Game");
    System.out.println("3. Exit");

    // take input
} while (userChoice != 3);
```

👉 WHY?

* Menu must show at least once
* Then repeat based on user input

---

# 🔹 5. FOR Loop

## ✅ WHAT

Compact loop for **known number of iterations**

---

## ✅ SYNTAX

```java
for (initialization; condition; update) {
    // code
}
```

---

## 🧠 Structure Breakdown

```java
for (int i = 1; i <= 10; i++)
```

| Part           | Meaning             |
| -------------- | ------------------- |
| Initialization | Start value         |
| Condition      | Loop continuation   |
| Update         | Increment/decrement |

---

## 🎯 Example

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

---

## 🔁 Flow of Execution

1. Initialization (once)
2. Check condition
3. Execute body
4. Update
5. Repeat

---

## 🔄 Reverse Loop

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

---

# 🔥 6. Infinite Loops

## WHILE

```java
while (true) {
    System.out.println("Hello");
}
```

---

## FOR

```java
for (;;) {
    System.out.println("Hello");
}
```

---

## ❌ Common Mistake

```java
for (int i = 1; i <= 10;) {
    System.out.println(i);
}
```

👉 Missing increment → infinite loop

---

# ⚙️ 7. Advanced FOR Loop Concepts

---

## 🧩 Multiple Variables

```java
for (int i = 1, j = 1; i <= 5; i++, j += 2) {
    System.out.println(i * j);
}
```

---

## 🔗 Multiple Conditions

```java
for (int i = 1, j = 1; i <= 10 && j <= 5; i++, j++) {
    System.out.println(i + " " + j);
}
```

---

## ❗ Important Rule

✔ Use logical operators (`&&`, `||`)
❌ Cannot use comma for conditions

---

# 🧠 8. Boolean-Based Loops

```java
boolean running = true;

for (; running; ) {
    // logic
    running = false;
}
```

👉 Loop depends on external condition

---

# 🧩 9. Empty Loop Body

```java
while (i < 10);
```

❌ Dangerous → infinite loop

---

# ⚡ 10. Loop Variable Type Insight

From transcript:

> Even if you use `byte` or `short`, Java promotes it to `int`

```java
byte i = 1; // internally promoted
```

✔ Best practice:

```java
int i = 1;
```

---

# 🔁 11. Nested Loops (Concept)

## ✅ WHAT

Loop inside another loop

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.println(i + "," + j);
    }
}
```

---

## 🧠 Use Cases

* Patterns
* Matrices
* Grids

---

# ⚖️ 12. While vs Do-While vs For

| Feature         | while              | do-while      | for              |
| --------------- | ------------------ | ------------- | ---------------- |
| Condition check | Before             | After         | Before           |
| Minimum runs    | 0                  | 1             | 0                |
| Readability     | Medium             | Medium        | Best             |
| Use case        | Unknown iterations | At least once | Known iterations |

---

# 💡 13. When to Use What?

### ✅ Use `while`

* Unknown number of iterations
* Condition-based loops

### ✅ Use `do-while`

* Must execute at least once
* Menus, user input

### ✅ Use `for`

* Fixed iterations
* Arrays, counting

---

# 🧪 14. Practice Problems

1. Print 1 to N
2. Reverse numbers
3. Sum of first N numbers
4. Multiplication table
5. Pattern printing (stars)
6. Factorial using loop

---

# 🎯 Final Summary

* Loops = repetition + control
* 3 main types: `while`, `do-while`, `for`
* Avoid infinite loops unless intended
* Always ensure termination condition
* Prefer `for` for counting loops
* Use `do-while` for menus

---