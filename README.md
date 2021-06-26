# Support Syntax
Refer to https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference
## DataTypes
* string
```typescript
let authorName: string = "tankilo";
```
* number              
typescript `number` datatype will be cast to java type `Double`.
```typescript
let age: number=18;
console.log(18); // will print 18.0
```

* boolean
```typescript
let state: boolean = false;
```

* any
Infact, type annotaion is ignored and the type of a variable is inferred based on the type of its initializer.
```typescript
let myFavoriteNumber: any = 'seven';
```

* object literal
```typescript
const object = { a: 1, b: 2, c: 3 };
console.log(object["a"]);
console.log(object.b);
```

*  Array
```typescript
let fibonacci: number[] = [1, 2, 3, 4, 5];
console.log(fibonacci[1]);
```

```typescript
let [a, b, c] = [1, 2, 3]; console.log(a);
```

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
var myObj = 1+"2";
console.log(myObj);// will print 1.02 instead of 12. because `1` is read as Double.
```

### [Member operators (Property accessors)](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators#left-hand-side_expressions)
> Property accessors provide access to an object's properties by using the dot notation or the bracket notation.

```typescript
const object = { a: 1, b: 2, c: 3 };
console.log(object["a"]);
console.log(object.b);
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

```typescript
let x: number = 10, y = 20;

if (x < y)
{
    console.log('x is less than y');
} 
```