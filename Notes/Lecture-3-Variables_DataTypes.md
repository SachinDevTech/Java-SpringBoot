# Java Basics Revision Notes

## 1. Variables and Identifiers

* **Variable:** A 'container' in the computer's memory (RAM) that stores a specific data value.
* **Identifier:** The unique name given to that container/variable (e.g., `firstNumber`, `x`, `y`) so we can refer to it in our code.
* **Naming Convention:** Always use descriptive names. The identifier should clearly describe what kind of data the variable is holding.

## 2. Data Types

Java is a **Statically Typed** language. This means you must declare the data type of a variable before you can use it (even before compilation).

Data types are broadly categorized into two types:

1. **Primitive Data Types** (The focus of these notes)
2. **Non-Primitive Data Types** (e.g., Classes, Arrays - covered later in Object-Oriented Programming)

### Primitive Data Types (4 Main Categories):

#### A. Integers (Whole numbers without decimals)

Java provides 4 types of integers based on the size (range) of the number you want to store:

1. **`byte`**: Takes 8 bits of memory. (Range: -128 to +127)
2. **`short`**: Takes 16 bits of memory.
3. **`int`**: Takes 32 bits of memory. (This is the most commonly used integer type).
4. **`long`**: Takes 64 bits of memory. (Used for exceptionally large numbers).

#### B. Real/Floating-Point Numbers (Numbers with decimals)

1. **`float`**: Takes 32 bits of memory (Single Precision).
2. **`double`**: Takes 64 bits of memory (Double Precision).

#### C. Characters

* **`char`**: Takes 16 bits of memory.
* Must be enclosed within single quotes `''` (e.g., `'A'`).
* **Unicode Support:** Unlike older languages that used the 8-bit ASCII standard, Java uses a 16-bit Unicode standard. This allows Java to represent characters from virtually any language globally (e.g., Greek, Chinese, Hindi, etc.).

#### D. Booleans

* **`boolean`**: This data type can strictly hold only one of two values: `true` or `false`.

---

## 3. Literals and Number Systems

* **Literal:** The actual, raw value stored directly inside a variable (e.g., in the statement `int x = 5;`, the number `5` is the literal).
* **Representing Literals in Different Number Systems:**
1. **Decimal (Default):** Base 10 (e.g., `10`)
2. **Binary:** Base 2. Prefix the literal with `0b` (e.g., `0b1001` equals 9).
3. **Octal:** Base 8. Prefix the literal with `0` (e.g., `05`).
4. **Hexadecimal:** Base 16. Prefix the literal with `0x` (e.g., `0x1F` or `0xA`).



---

## 4. Declaration vs. Definition (Initialization)

* **Declaration:** The act of creating a variable and stating its type. Example: `int x;` (The compiler reserves the required space in memory).
* **Definition:** The act of assigning a literal value to that declared variable. Example: `x = 5;`
* *Note:* You can declare and define at the same time: `int x = 5;`

---

## 5. Keywords and Comments

* **Keywords:** Java has 68 reserved words that have special meaning to the compiler. You **cannot** use these words as identifiers (variable names). Examples include `class`, `public`, `int`, `static`. Fun fact: words like `goto` and `const` are reserved but never actually used in Java.
* **Comments:** Used to write human-readable notes in the code. The compiler completely ignores them.
* Single-line comment: `// This is a comment`
* Multi-line comment: `/* This is a multi-line comment */`



---

## 🧠 Important Logics & Things to be Aware Of

* **The "Default Double" Rule:** In Java, any decimal number written in the code is treated as a `double` by default. If you try to store a decimal literal in a `float` variable, you **must** append an `f` or `F` at the end of the number (e.g., `float myNum = 10.5f;`). If you forget the `f`, the compiler will throw a "Type Mismatch" error because it thinks you are trying to squeeze a 64-bit double into a 32-bit float container.
* **Float vs. Double in Production:** Modern hardware processors are heavily optimized for `double` precision calculations. Therefore, `double` is the industry standard for decimal calculations. `float` is rarely used in modern real-world/production applications.
* **Strict Booleans:** If you are coming from a C or C++ background, remember that Java does **not** treat `0` as false and `1` (or any non-zero number) as true. In Java, a boolean is strictly `true` or `false`.
* **Readability with Underscores:** To make massive numbers easier to read, Java allows you to place underscores `_` between digits (e.g., `int salary = 1_00_00_000;`). The compiler simply ignores the underscores. *Logic constraint:* You cannot place an underscore immediately before or after a decimal point, or at the very beginning/end of the literal.
* **Scientific Notation:** For massive or microscopic numbers, you can use scientific notation by utilizing the exponent `e` (e.g., Avogadro's number can be written as `double d = 6.022e23;`).
* **All Integers are Signed:** Every integer data type in Java is "signed," meaning it is designed to hold both negative and positive numbers. The memory range is split down the middle (with zero in the center). This is why the maximum positive value is always one less than the absolute minimum negative value. The formula for the range of an -bit integer is  to .