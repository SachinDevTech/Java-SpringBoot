
---

# 🧠 Chapter 11: Functions (Java)


## 🔥 1. WHAT is a Function?

> A function is a **block of code that performs a specific task and can be reused multiple times** 

---

### ❌ Problem without functions

```java
int a = 4, b = 5;
int sum = a + b;
System.out.println(sum);

// again same code 😓
int x = 10, y = 20;
int sum2 = x + y;
System.out.println(sum2);
```

👉 Code repetition ❌
👉 Hard to maintain ❌

---

### ✅ Solution: Function

```java
static int sum(int a, int b) {
    return a + b;
}
```

```java
int result1 = sum(4, 5);
int result2 = sum(10, 20);
```

👉 Reusable ✔
👉 Clean ✔

---

## 🧩 2. Anatomy of a Function

```java
static int sum(int a, int b) {
    return a + b;
}
```

---

### Breakdown:

| Part             | Meaning                                            |
| ---------------- | -------------------------------------------------- |
| `static`         | keyword (ignore for now, required in main context) |
| `int`            | return type                                        |
| `sum`            | function name                                      |
| `(int a, int b)` | parameters                                         |
| `{}`             | function body                                      |
| `return`         | gives output                                       |

---

## 🎯 3. Return Type (VERY IMPORTANT)

> Return type = **What function gives back**

---

### Example:

```java
static int getNumber() {
    return 10;
}
```

👉 returns integer

---

### Void Function

```java
static void greet() {
    System.out.println("Hello");
}
```

👉 returns nothing

👉 `void` = empty / no return

---

## 🧠 4. Parameters vs Arguments

---

### 👉 Parameters (definition time)

```java
static int sum(int a, int b)
```

👉 `a`, `b` → parameters

---

### 👉 Arguments (call time)

```java
sum(4, 5);
```

👉 `4`, `5` → arguments

---

### 🔥 Key Line

> Parameters = placeholders
> Arguments = actual values

---

## ⚡ 5. Function Calling (Flow of Control)

```java
int result = sum(4, 5);
```

---

### 🧠 Behind the scenes:

1. Call function
2. Jump to function
3. Execute
4. Return value
5. Continue program

👉 This flow is explained clearly in your notes 

---

## 🧩 6. Types of Functions (VERY IMPORTANT)

---

### ✅ 1. No Input, No Output

```java
static void greet() {
    System.out.println("Hello");
}
```

---

### ✅ 2. Input, No Output

```java
static void sayHello(String name) {
    System.out.println("Hello " + name);
}
```

---

### ✅ 3. No Input, Output

```java
static int getNumber() {
    return 10;
}
```

---

### ✅ 4. Input + Output (MOST USED)

```java
static int multiply(int a, int b) {
    return a * b;
}
```

---

## 🔥 7. Main Function (ENTRY POINT)

```java
public static void main(String[] args) {
}
```

---

### 🧠 Important:

* `main` is also a function
* Program starts from here
* JVM calls it automatically

👉 If you don’t call other functions inside `main` → they won’t execute 

---

## ⚠️ 8. Key Rules You MUST Know

---

### ✅ Rule 1: Function must be called

```java
greet(); // otherwise no execution
```

---

### ✅ Rule 2: Return type must match

```java
static int get() {
    return 10; // OK
}
```

❌ Wrong:

```java
static int get() {
    return "hello"; // error
}
```

---

### ✅ Rule 3: If return type ≠ void → must return

---

### ✅ Rule 4: Parameter types must match

```java
sum(4, 5); // OK
sum("a", "b"); // ❌
```

---

## 🔥 9. Function Overloading (INTERVIEW FAVORITE)

> Same function name, different parameters

---

### ✅ Example:

```java
static int sum(int a, int b) {
    return a + b;
}

static int sum(int a, int b, int c) {
    return a + b + c;
}
```

---

### 👉 Also possible:

```java
static double sum(double a, double b) {
    return a + b;
}
```

---

### 🧠 Compiler decides based on:

* number of parameters
* type of parameters

👉 Covered in your notes 

---

## ⚡ 10. Important Concepts (Deep Understanding)

---

### 🔹 1. Functions = Abstraction

Hide logic, show usage

---

### 🔹 2. Code Reusability

Write once, use many times

---

### 🔹 3. Modular Programming

Break big problems into small parts

---

### 🔹 4. Readability

Cleaner code → easier debugging

---

## 🧠 11. Real-Life Analogy

👉 Function = Machine

* Input → raw material
* Process → inside logic
* Output → final product

---

## 🚀 12. Advanced Insights (Important for You)

---

### 🔥 Function can call another function

```java
static int square(int x) {
    return x * x;
}

static int sumOfSquares(int a, int b) {
    return square(a) + square(b);
}
```

---

### 🔥 Return value can be ignored

```java
getNumber(); // valid but useless
```

👉 Output lost (as shown in your notes) 

---

## 🎯 FINAL INTERVIEW SUMMARY

👉 If interviewer asks “What is a function?”

**Answer:**

> “A function is a reusable block of code that performs a specific task, can take inputs (parameters), and may return a value. It improves modularity, readability, and reduces code duplication.”

---

# 🔥 Practice Questions (VERY IMPORTANT)

Try these:

1. Write function to check even/odd
2. Function to find max of 3 numbers
3. Function to reverse a number
4. Function to calculate factorial
5. Function to check prime

---