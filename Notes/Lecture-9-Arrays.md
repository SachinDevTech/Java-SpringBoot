
---

# 📦 Chapter 9: Arrays (Java)


## 🚀 1. What is an Array?

### 👉 Simple Idea

> Array = collection of same type data stored together

---

### ❌ Without Array

```java
int r1 = 1001;
int r2 = 1002;
int r3 = 1003;
```

---

### ✅ With Array

```java
int[] rollNumbers = new int[3];
```

✔ One variable
✔ Stores multiple values
✔ Clean & scalable

---

### 🧠 Concept

* Array stores values in **continuous memory**
* Each value has an **index (position)**
* Index starts from **0**

📌 From lecture: arrays store elements in **contiguous memory locations** 

---

## 🔢 2. Declaration & Initialization


### 👉 Declaration

```java
int[] arr;
```

---

### 👉 Initialization

```java
arr = new int[3];
```

---

### 👉 Combined

```java
int[] arr = new int[3];
```

---

### 🧠 Meaning

* `int` → type
* `[]` → array
* `3` → size

---

## 🧩 3. Indexing (Important)

| Index | Value  |
| ----- | ------ |
| 0     | First  |
| 1     | Second |
| 2     | Third  |

---

### 👉 Example

```java
int[] arr = new int[3];

arr[0] = 1001;
arr[1] = 1002;
arr[2] = 1003;
```

---

## 📤 4. Access / Print Elements

```java
System.out.println(arr[0]); // 1001
System.out.println(arr[1]); // 1002
System.out.println(arr[2]); // 1003
```

---

## 🔁 5. Using Loop with Array (Very Important)

### ❌ Manual

```java
System.out.println(arr[0]);
System.out.println(arr[1]);
System.out.println(arr[2]);
```

---

### ✅ Using loop

```java
for (int i = 0; i < 3; i++) {
    System.out.println(arr[i]);
}
```

---

### 🔥 Best Practice (Dynamic)

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

### 🧠 Why `.length`?

* Avoid hardcoding
* Works for any size

---

## ⚙️ 6. Filling Array using Loop

```java
int[] arr = new int[3];
int x = 1001;

for (int i = 0; i < arr.length; i++) {
    arr[i] = x;
    x++;
}
```

✔ Efficient
✔ No manual work

---

## ⚠️ 7. Common Error

### ❌ Out of Bound

```java
System.out.println(arr[3]); // Error
```

---

### 🚨 Error Name

> **ArrayIndexOutOfBoundsException**

📌 Happens when index ≥ size 

---

## 📏 8. Array Length

```java
System.out.println(arr.length);
```

✔ Returns size of array

---

# 🔷 9. Types of Arrays

---

## 🟢 (A) 1D Array

```java
int[] arr = new int[3];
```

👉 Looks like:

```
[10, 20, 30]
```

---

## 🔵 (B) 2D Array (Very Important)

### 👉 Concept

> Array of Arrays

---

### 👉 Example (Marks System)

|    | Sub1 | Sub2 | Sub3 |
| -- | ---- | ---- | ---- |
| S1 | 50   | 30   | 90   |
| S2 | 60   | 40   | 80   |
| S3 | 70   | 50   | 70   |

---

### 👉 Code

```java
int[][] marks = new int[3][3];
```

---

### 👉 Indexing

```java
marks[0][0] = 50;
marks[0][1] = 30;
marks[0][2] = 90;
```

---

### 👉 Access

```java
System.out.println(marks[1][2]); // 80
```

---

## 🔁 10. Loop in 2D Array

```java
for (int i = 0; i < marks.length; i++) {
    for (int j = 0; j < marks[i].length; j++) {
        System.out.print(marks[i][j] + " ");
    }
    System.out.println();
}
```

---

### 🧠 Concept

* `i` → rows
* `j` → columns

---

# ⚖️ 11. 1D vs 2D Array

| Feature   | 1D          | 2D            |
| --------- | ----------- | ------------- |
| Structure | Line        | Table         |
| Index     | 1           | 2             |
| Use       | Simple list | Matrix / grid |

---

# 🎯 Final Summary

* Array = collection of same type
* Index starts from **0**
* Stored in **continuous memory**
* Use `.length` instead of hardcoding
* Use loops for efficiency
* 2D array = array of arrays

---

## 🧠 Intuition (Must Remember)

* Array = **container with slots**
* Index = **address of slot**
* Loop = **automatic filling / reading**

---
