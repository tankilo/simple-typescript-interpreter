# Support Syntax

Refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference

## DataTypes
Tips: Infact, type annotaion is ignored and the type of a variable is inferred based on the type of its initializer.

* string
```typescript
let authorName: string = "tankilo";
```

* number                  
typescript `number` datatype will be cast to java type `Double`.
```typescript
let age: number = 18;
console.log(18); // will print 18.0
```

* boolean
```typescript
let state: boolean = false;
```

* any
```typescript
let myFavoriteNumber: any = 'seven';
```

* object literal
```typescript
const object = {a: 1, b: 2, c: 3};
console.log(object["a"]);
console.log(object.b);
```

* Array
```typescript
let fibonacci: number[] = [1, 2, 3, 4, 5];
console.log(fibonacci[1]);
```

```typescript
let [a, b, c] = [1, 2, 3];
console.log(a);
```

## Variable Declaration
Only support the let declarations!!!

## Operators

### Relational operators

* <         
  Less than operator.
* \>          
  Greater than operator.
* <=            
  Less than or equal operator.
* \>=                                
  Greater than or equal operator.

only support operands with string or number datatype and both operands should have the same datatype!

example:

```typescript
console.log(5 < 3);
console.log(3 <= 3);

console.log(3 > 3);
console.log(3 >= 3);

console.log("a" < "b");
console.log("a" <= "a");
console.log("a" > "a");
console.log("b" >= "a");
```

### Arithmetic operators

* \+              
  Addition operator.
* \-             
  Subtraction operator.
* /               
  Division operator.
* \*              
  Multiplication operator.
* %                            
  Remainder operator.

#### about Addition (+)

* Numeric addition
* String concatenation

currently, please concatenate operhand with the same datatype.

bad example:

```typescript
var myObj = 1 + "2";
console.log(myObj);// will print 1.02 instead of 12. because `1` is read as Double.
```

### [Member operators (Property accessors)](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators#left-hand-side_expressions)

> Property accessors provide access to an object's properties by using the dot notation or the bracket notation.

```typescript
const object = {a: 1, b: 2, c: 3};
console.log(object["a"]);
console.log(object.b);
```

### Binary logical operators

* &&    
  Logical AND.
* ||  
  Logical OR.

```typescript
const a = 3;
const b = -2;

console.log(a > 0 && b > 0);
// expected output: false
console.log(a > 0 || b > 0);
// expected output: false
```

### Unary operators

* \-      
  The unary negation operator converts its operand to Number type and then negates it.

* \!          
  Logical NOT operator.

### Postfix/prefix increment and postfix/prefix decrement operators

* A++   
  Postfix increment operator.
* A--   
  Postfix decrement operator.
* ++A    
  Prefix increment operator.
* --A    
  Prefix decrement operator.

### Equality operators

Currently, `===` and `!==` behave the same as `==` or `!=`.

* ==    
  Equality operator.
* !=   
  Inequality operator.
* ===   
  Identity operator.
* !==   
  Nonidentity operator.

### Assignment operators

* =      
  Assignment operator.

### Ternary operator

```typescript
let x: number = 10, y = 20;

x > y ? console.log('x is greater than y.') : console.log('x is less than or equal to y.')

// expect output: x is less than or equal to y.
```

## Function Declaration

### Named Functions.

```typescript
function display() {
    console.log("Hello TypeScript!");
}

display(); //Output: Hello TypeScript! 
```

### Anonymous Function

```typescript
let Sum = function (x: number, y: number): number {
    return x + y;
}

console.log(Sum(2, 3)); // returns 5.0
```

### [Rest parameters](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/rest_parameters)

Input:

```typescript
function Greet(greeting: string, ...names: string[]) {
    return greeting + " " + names + "!";
}

console.log(Greet("Hello", "Steve", "Bill")); // Hello Steve,Bill!

console.log(Greet("Hello"));
;// Hello !
```

Output:

```
Hello [Steve, Bill]! 
Hello []! 
```

### [Arrow function expressions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)

example:

```typescript
let Print = () => console.log("Hello TypeScript");
Print();
```

### [Default parameters](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Default_parameters)

example:

```typescript
function applyDiscount(price, discount = 0.05) {
    return price * (1 - discount);
}

console.log(applyDiscount(100)); // 95
console.log(applyDiscount(100, undefined)); // 95

```

```typescript
function applyDiscount(discount = 0.05, price) {
    return price * (1 - discount);
}

console.log(applyDiscount(undefined, 100)); // 95
```

## IF

```typescript
let name = "javascript";
if (name == "python") {
    console.log("python");
} else if (name == javascript) {
    console.log(javascript);
} else {
    console.log("java NO.1");
}
```

```typescript
let y = 1;

if (true) {
    let y = 2;
    console.log(y);
}

console.log(y);
```

```typescript
let x: number = 10, y = 20;

if (x < y) {
    console.log('x is less than y');
} 
```

## [Switch](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/switch)

### Example1

Input:

```typescript
var foo = 0;
switch (foo) {
    case -1:
        console.log('negative 1');
        break;
    case 0: // foo is 0 so criteria met here so this block will run
        console.log(0);
    // NOTE: the forgotten break would have been here
    case 1: // no break statement in 'case 0:' so this case will run as well
        console.log(1);
        break; // it encounters this break so will not continue into 'case 2:'
    default:
        console.log('default');
    case 2:
        console.log(2);
        break;
}
```

Expected output:

```typescript
0.0
1.0 
```

### Example2

Input:

```typescript
const action = 'say_hello';
switch (action) {
    case 'say_hello': { // added brackets
        let message = 'hello';
        console.log(message);
        break;
    } // added brackets
    case 'say_hi': { // added brackets
        let message = 'hi';
        console.log(message);
        break;
    } // added brackets
    default: { // added brackets
        console.log('Empty action received.');
        break;
    } // added brackets
}
```

Expected output:

```typescript
hello
```

## For

### for statement

```typescript
let str = '';

for (let i = 0; i < 9; i++) {
    str = str + i;
}

console.log(str);
// expected output: "0.01.02.03.04.05.06.07.08.0"
```

```typescript
let str = '';
let i;
for (i = 0; i < 9; i++) {
    str = str + i;
}

console.log(str);
// expected output: "0.01.02.03.04.05.06.07.08.0"
```

### for...in statement

```typescript
const object = {a: 1, b: 2, c: 3};

for (const property in object) {
    console.log(property);
}
// expected output:
//a
//b
//c
```

```typescript
let str = "He";

for (var index in str) {
  console.log(index+""+str[index]); 
}

// expected output:
// 0H
// 1e
```

```typescript
let arr = [10, 20, 30, 40];

for (var index in arr) {
  console.log(index+" "+arr[index]);
}
// expected output:
//0 10.0
//1 20.0
//2 30.0
//3 40.0 
```
### for...of statement

```typescript
let arr = [10, 20, 30, 40];

for (var val of arr) {
  console.log(val);
}
// expected output:
//10.0
//20.0
//30.0
//40.0
```

```typescript
let str = "He";

for (var char of str) {
  console.log(char); // prints chars: H e l l o  W o r l d
}

// expected output:
// H
// e
```

## While
```typescript
let n = 0;

while (n < 3) {
  n++;
}

console.log(n);
// expected output: 3.0
```

## [Block Scope](https://www.typescriptlang.org/docs/handbook/variable-declarations.html#block-scoping)

> When a variable is declared using let, it uses what some call lexical-scoping or block-scoping. Unlike variables declared with var whose scopes leak out to their containing function, block-scoped variables are not visible outside of their nearest containing block or for-loop.

```typescript
let y = 1;

if (true) {
    let y = 2;
    console.log(y);
}

console.log(y);
```

output:

```
2.0 
1.0 
```
