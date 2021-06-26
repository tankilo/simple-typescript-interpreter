# Support Syntax
Refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference
## DataTypes
### Array

## Operators
### Addition (+)
* Numeric addition     
  js number datatype will be read as string, if it contains `.`, then will be cast to java type Double, otherwise cast to Integer.
* String concatenation

## Function
```typescript
let Print = () => console.log("Hello TypeScript");
Print();
```

```
====================Input======================
function Greet(greeting: string, ...names: string[]) {
    return greeting + " " + names + "!";
}

console.log(Greet("Hello", "Steve", "Bill")); // Hello Steve,Bill!

console.log(Greet("Hello"));;// Hello !

====================Output=====================
Hello [Steve, Bill]! 
Hello []! 
===============================================
```

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

