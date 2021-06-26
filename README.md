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

```typescript
function Greet(greeting: string, ...names: string[]) {
  return greeting + " " + names.join(", ") + "!";
}

Greet("Hello", "Steve", "Bill"); // returns "Hello Steve, Bill!"

Greet("Hello");// returns "Hello !
```

