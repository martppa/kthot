# KotlinJSL ![](https://img.shields.io/badge/maven_central-0.1.1-004475)
A typesafe Kotlin DSL for JavaScript. Write, reuse and interact with Javascript without [WASM](https://kotlinlang.org/docs/wasm-overview.html).

<img width="819" height="260" alt="Gemini_Generated_Image_9dyhip9dyhip9dyh_cropped-2" src="https://github.com/user-attachments/assets/b08775fa-af73-4842-845c-29cb8e419074" />

## Motivation
As Kotlin developers and users of [Kotlin Html Dsl](https://kotlinlang.org/docs/typesafe-html-dsl.html) we may want to write JavaScript code while staying in Kotlin. This tool is meant to generate JavaScript code whithin Kotlin. It's meant for scripts, so, if what you are looking for is writing entire projects in JavaScript using Kotlin, [WASM](https://kotlinlang.org/docs/wasm-overview.html) may be your tool. This DSL is currently under development and it's in experimental stage.

> **Important:** This readme file does not cover the whole code, therefore, it might not explain every aspect of this DSL. If you find this repo interesting and wanna give it a try, please open an issue requesting the documentation.

## Installation
In order to include the DSL, add the following dependencies to your project build.gradle file:
```groovy
dependencies {
    implementation "net.asere.kotlin:js-dsl:$version"
}
```

## Overview
The DSL is currently capable of offering some basic functionalities. Its main goal is to allow developers write JavaScript scripts while staying in Kotlin. There are two kind of syntax builders: 

- **Dsl builders:** These builders in most cases will write the JavaScript code for you. These are the equivalent to reserved words (`for`, `when`, `if`, etc.). They mostly return references to JS objects and values.
- **Regular builders:** These builders in most cases return syntax and syntax-builder objects. For this kind of builders, you must use the unary plus operator (+) to add the JS syntax to the scope.

## Variable 

### Definition

As for most statements, you can define them using both kind of builders

**Regular builders:**

Define a basic string variable. `JsString` is the Kotlin representation for the `String` type in Javascript. Use the `js` function to generate the syntax. `js` function will pack all instructions and return them as a single `JsSyntax` object. Use the unary plus (+) operator to "print" any `JsElement` on the scope of `js` function's lambda. 
The `declare` function will write the variable declaration, it could be mutable or constant.

```kotlin
val syntax = js {
    +JsString.def().declare(Let)        
}
println(syntax)
```

The code above is translated to:

```javascript
    let string_1
```

When no `name` argument is provided to `def()` build extension function, a default name to the object reference is given.

### Assign values to declared references

In order to assign values to a JavaScript object use the `assign` extension function. In this case in the example the `js` extension `val` is used to turn the `String` into a `JsString` accepted by the `assign` function.

```kotlin
val syntax = js {
    +JsString.def().declare(Let).assignValue("Juan".js)
}
println(syntax) // --> let string_1 = "Juan"
```

**Dsl builders:**

This way looks simpler and closer to what JavaScript syntax would look like.

```kotlin
val constBoolean = Const { JsBoolean.def() } assign true
val letBoolean = Let { JsBoolean.def() } assign true
val varBoolean = Var { JsBoolean.def() } assign false
```

You still can declare variables without assigning them:

```kotlin
val letBoolean = +Let { JsBoolean.def() }
val varBoolean = +Var { JsBoolean.def() }
```

Since declaration functions (`Var`, `Let`, `Const`) return `JsSyntax` we need to use unary plus (+) to write the JavaScript code.

### Referencing objects in Kotlin

Use object's definitions to declare them (e.g `JsString.def()`). Definitions are references, every object reference (e.g `JsString.def()`) can be assigned to a Kotlin object to interact with it. In the example below the `JsString` definition is stored in `stringValue`, then the first character of 'Juan' is printed.

```kotlin
val syntax = js {
    val stringValue = +JsString.def().declare(Let).assignValue("Juan".js)
    Log(stringValue.charAt(0.js))
    
    // Using DSL builders
    val fancyStringValue = Let { JsString.def() } assign "Juan"
    Log(fancyStringValue.charAt(0.js))
}
println(syntax)
```
Output:
```javascript
    let string_1 = "Juan"
    console.log(string_1.charAt(0))
    
    let string_2 = "Juan"
    console.log(string_2)
```

## Operators

### Arithmetical

Arithmetical operators are overloaded in Kotlin so you can use them like you would do in Javascript.

```kotlin
val syntax = js {
    val result = Const { JsNumber.def("result") } assign (5.js - 3.js) * (10.js + 2.js)
    val text = Const { JsString.def("text") } assign "The result is: ".js + result
    Log(text)
}
println(syntax)
```

Output:
```javascript
const result = (5 + 3) * (10 + 2)
const text = 'The result is: ' + result
console.log(text)
```

### Logical

Logical operators can be applied using infix functions to emulate them:

| Javascript operator | Kotlin reference |
|---------------------|------------------|
| &&                  | and              |
| II                  | or               |
| !                   | !                |

```kotlin
val syntax = js {
    val bool0 = Const { JsBoolean.def() } assign true
    val bool1 = Const { JsBoolean.def() } assign false
    val result = Const { JsBoolean.def("result") } assign bool0 and bool1
    Log(result)
}
println(syntax)
```

Output:
```javascript
const boolean_1 = true
const boolean_2 = false
const result = boolean_1 && boolean_2
console.log(result)
```

### Equality

| Javascript operator | Kotlin reference |
|---------------------|------------------|
| ==                  | eq               |
| != | neq |
| ===                 | seq              |
| !== | nseq |
| !                   | !                |

```kotlin
val syntax = js {
    val result = Const { JsBoolean.def("result") } assign (5.js eq 5.js)
    Log(result)
}
println(syntax)
```

Output:
```javascript
const result = 5 == 5
console.log(result)
```

You can use parenthesis to group expressions just like you would do it in Kotlin.

```kotlin
val syntax = js {
    val bool0 = +JsBoolean.def().declare(Const).assignValue(5.js eq 5.js)
    val bool1 = +JsBoolean.def().declare(Const).assignValue(false)
    val bool2 = +JsBoolean.def().declare(Const).assignValue(true)
    +jsLog(bool1 and (bool2 or bool0))
}
println(syntax)
```

Output:
```javascript
const boolean_4 = 5 == 5
const boolean_5 = false
const boolean_6 = true
console.log(boolean_5 && (boolean_6 || boolean_4))
```

## Collections

Declaring collections. Please note as `collection.forEach` does return a `JsSyntax` you need to apply the unary plus (+) to make it print the function in JavaScript. To build a `JsArray` reference you need to pass a builder for the generic element. Syntax builders e.g. `JsNumber::syntax` are the best option, unless you need a custom one.

```kotlin
val syntax = js {
    val collection = Const { JsArray.def(JsNumber::syntax) } assign JsArray.value(0.js, 1.js, 2.js, 3.js, 4.js)
    +collection.forEach(jsLambda(JsNumber.def()) { number1 ->
        Log(number1)
    })

    // Fancy way
    For (collection, JsLambda.value(JsNumber.def()) { number2 ->
        Log(number2)
    })
}
println(syntax)
```

Output:
```javascript
const collection_1 = [0, 1, 2, 3]
collection_1.forEach((number_2) => {
    console.log(number_2)
})    
```

## If statements

You can declare `if` statements using the `If` dsl function inside a `jsScript` scope:

```kotlin
val bool0 = Const { JsBoolean.def() } assign true
val bool1 = Const { JsBoolean.def() } assign false
val bool2 = Const { JsBoolean.def() } assign true

+jsIf((!bool0 and bool1) or (bool1 and bool2)) {
    Log("and!")
}.jsElseIf(bool0 or (bool1 or bool2)) {
    Log("or!")
}.jsElseIf((bool0 or bool1) or bool2) {
    Log("or!")
}.jsElse {
    Log("else!")
}

// Fancy way
If ((!bool0 and bool1) or (bool1 and bool2)) {
    Log("and!")
}
ElseIf (bool0 or (bool1 or bool2)) {
    Log("or!")
}
ElseIf((bool0 or bool1) or bool2) {
    Log("or!")
}
Else {
    Log("else!")
}
```

Output:
```javascript
if ((!boolean_0 && boolean_1) || (boolean_1 && boolean_2)) {
    console.log('and!')
}
else if (boolean_0 || (boolean_1 || boolean_2)) {
   console.log('or!')
}
else if ((boolean_0 || boolean_1) || boolean_2) {
   console.log('or!')
}
else {
   console.log('else!')
}
```

## Loops

There's support for loops statements too!

### For loops

**Classic i counter:** Define the classic FOR loop giving 3 parameters to the `For` dsl function. Define the counter named "i" in this case, then create the evaluation and the operation for each iteration

```kotlin
val syntax = js {
    val collection = Const { JsArray.def<JsNumber>() } assign JsArray.value(0.js, 1.js, 2.js, 3.js)
    For ({ Let { JsNumber.def("i") } assign 0 }, { it lt collection.getLength() }, { it.postInc() }) {
        Log(it)
        If (it lt 2) {
            Break
        }
    }
}
println(syntax)
```

**Object key iteration:** Define key iteration for loop

```kotlin
val obj = Const { JsObject.def("obj") } assign JsSyntax("{ a: 5 }")
For ({ Const { JsObject.def("key") } }, obj) {
    Log(obj[it])
}
```

Output:
```javascript
const obj = { a: 5 }
for (const key in obj) {
    console.log(obj[key])
}
```

**Collection iteration:** Define the for loop to iterate a collection

```kotlin
val collection = Const { JsArray.def<JsNumber>() } assign JsArray.value(0.js, 1.js, 2.js, 3.js)
For ({ Const { JsNumber.def() } }, collection) {
    Log(it)
    If (it eq 5.js) {
        Continue
    }
}
```

## Declare functions

### No argument functions

Function declaration is designed to be as close as possible to Javascript and Kotlin syntax. In the code below we define a function with no arguments. Please note we use the unary plus (+) operator to invoke the function. Function invocation returns a `JsSyntax`.

```kotlin
val simpleFunction = Function {
    Log("We called the function!")
}
+simpleFunction()
```

Output:
```javascript
function function_0() {
    console.log('We called the function!')
}
function_0()
```

### Functions with arguments

To define functions with arguments call the overloaded `Function` and specify the arguments using value references

```kotlin
val syntax = js {
    val greet = Function(name = "greet", JsString.def(), JsString.def(), JsNumber.def()) { string1, string2, number ->
        Log(string1 + string2 + number)
    }
    +greet("Hello, ".js, "World".js, 5.js)
}
println(syntax)
```
Output:
```javascript
function greet(string_2, string_3, number_4) {
    console.log((string_2 + string_3) + number_4)
}
greet('Hello, ', 'World', 5)
```

### Lambdas

Lambdas behave similar to functions except that these have no name. Still, they can be referenced to declarable objects. To declare lambdas use the `jsLambda` function

**No argument lambda**

```kotlin
// Usage of unary plus to force the rendering in sake of documentation
+jsLambda {
    Log("Inside a lambda")
}
```

Output:
```javascript
() => {
    console.log('Inside a lambda')
}
```

**Multiple arguments lambda**

```kotlin
jsLambda(
    JsString.def(),
    JsString.def()
) { first, second ->
    Return(first + second)
}
```

Output:

```javascript
(string_3, string_4) => {
    return string_3 + string_4
}
```

As mentioned before, lambdas can be referenced using lambda reference objects. You can invoke lambdas using there objects anytime.

```kotlin
val sum = Const { JsLambda2.def<JsNumber, JsNumber>() } assign jsLambda(
    JsString.def("first"),
    JsString.def("second")
) { first, second ->
    Return(first + second)
}
Log(sum(5.js, 4.js))
```

Output:
```javascript
const lambda_2 = (first, second) => {
    return first + second
}
console.log(lambda_2(5, 4))
```

**Define a function that accepts lambda as parameter**

You can define lambda as parameter types. For example, when passing it to a function or a class. Also, it can used inline.

```kotlin
val setOnClick = Function("setOnClick", JsLambda1.def<JsString>("sender")) { callback ->
    callback("button".js)
}
// Then call it later
setOnClick(jsLambda(JsString.def("sender")) {
    Log("Event emitted by " + +it)
})
```
> The number in function and lambda names refers to the amount of parameters it accepts.

**References as parameters:**

Created lambda references can be also used as parameters

```kotlin
val printItem = Const { JsLambda1.def<JsNumber>("printItem") } assign jsLambda(
    JsString.def("item"),
) { item ->
    Log(item)
}
val numberCollection = Const { JsArray.def<JsNumber>("numberCollection") } assign JsArray.value(100.js, 200.js, 300.js)
+numberCollection.forEach(printItem)
```

Output:
```javascript
const printItem = (item) => {
    console.log(item)
}
const numberCollection = [100, 200, 300]
numberCollection.forEach(printItem)
```

## Integrate with Html DSL

### Installation

In order to include the DSL support for Kotlin Html DSL, add the following dependencies to your project build.gradle file:
```groovy
dependencies {
    implementation "net.asere.kotlin:js-dsl-html:$version"
}
```

Javascript code can be integrated with the Html DSL using `jsScript` function

```kotlin
val showAlert = JsFunction1Ref<JsString>("showAlert")
val html = createHTML().html {
    head {
        jsScript {
            Function(name = "showAlert", JsString.def()) {
                +Window.alert(it)
            }
        }
    }
    body {
        button {
            onClick = "${showAlert("Hello World!".js)}"
            +"Click me"
        }
    }
}
println(html)
```

Output:

```html
<html>
<head>
 <script>
     function showAlert(string_0) {
         window.alert(string_0)
     }
 </script>
</head>
<body>
 <button onclick="showAlert('Hello World!')">Click me</button>
</body>
</html>
```

# Known issues

- Indentation generated by the DSL in some cases may not follow the expected spacing. It does not affect the code itself.

# License - MIT

Copyright 2025 Asere.net

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
