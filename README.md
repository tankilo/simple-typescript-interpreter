# Support Syntax
Refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference
## DataTypes
```typescript
let state: boolean = false;
```

```typescript
var myObj = 1; console.log(myObj);
```

```typescript
let myFavoriteNumber: any = 'seven';
myFavoriteNumber = 7;
console.log(myFavoriteNumber);
```

```typescript
const object = { a: 1, b: 2, c: 3 };
console.log(object["a"]);
console.log(object.b);
```

```typescript
let o1 = { foo: undefined};
let o2 = { bar: 'hello' };

o1.foo = o2;
console.log(o1.foo.bar);
```

### Array
```typescript
let fibonacci: number[] = [1, 2, 3, 4, 5];
console.log(fibonacci[1]);
```

```typescript
let [a, b, c] = [1, 2, 3]; console.log(a);
```

## Operators
### Addition (+)
* Numeric addition     
  js number datatype will be read as string, if it contains `.`, then will be cast to java type Double, otherwise cast to Integer.
* String concatenation

```typescript
var myObj = 1+"2";
console.log(myObj);
```

```typescript
let state: number = 2/4;
```

```typescript
console.log(1 == 1);
```

## Function
```typescript
console.log(1,2,3);
```

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

## IF
```typescript
let name = "javascript";
if (name == "python") {
    console.log("python");
} else if ( name == javascript) {
    console.log(javascript);
} else  {
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
