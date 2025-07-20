# kotlin-js-dsl ![](https://img.shields.io/badge/jsDsl_version-0.0.2-004475)
This semi-typed DSL is intended to help kotlin developers write, reuse and interact with Javascript without ![WASM](https://kotlinlang.org/docs/wasm-overview.html). It was born under the need to help developers of ![Kotlin Html Dsl](https://kotlinlang.org/docs/typesafe-html-dsl.html) write JS code while staying in Kotlin. If what you are looking for is writing entire projects in JS using Kotlin, ![WASM](https://kotlinlang.org/docs/wasm-overview.html) is your tool. This tool is currently under development, and it's in an experimental stage. 

## Installation
In order to include the DSL, add the following dependencies to your project build.gradle file:
```groovy
dependencies {
    implementation "net.asere.kotlin:js-dsl:$version"
    implementation "net.asere.kotlin:js-dsl-html:$version"
}
```

The DSL is currently capable of offering some basic functionalities

## Variable 

### Definition

Define a basic string variable. `JsString` is the Kotlin representation for the `String` type in Javascript. Use the `js` function to generate the syntax. `js` function will pack all instructions and return them as a single `JsSyntax` object. Use the unary plus (+) operator to "print" any `JsElement` on the scope of `js` function's lambda. 
The `declare` function will write the variable declaration, it could be mutable or constant.

```kotlin
val syntax = js {
    +JsString.ref().declare(Mutable)        
}
println(syntax)
```

The code above is translated to:

```javascript
    let string_1
```

When no `name` argument is provided to `ref()` build extension function, a default name to the object reference is given.

### Assign values to declared references

In order to assign values to a JavaScript object use the `assign` extension function. In this case in the example the `js` extension val is used to turn the `String` into a `JsString` accepted by the `assign` function.

```kotlin
val syntax = js {
    +JsString.ref().declare(Mutable).assign("Juan".js)
}
println(syntax) // --> let string_1 = "Juan"
```

### Referencing objects in Kotlin

Every object reference (e.g `JsString.ref()`) can be assigned to a Kotlin object to interact with it. In the example below the `JsString` reference is stored in `stringValue`, then the first character of 'Juan' is printed.

```kotlin
val syntax = js {
    val stringValue = +JsString.ref().declare(Mutable).assign("Juan".js)
    +jsLog(stringValue.charAt(0.js))
}
println(syntax)
```
Output:
```javascript
    let string_1 = "Juan"
    console.log(string_1.charAt(0))
```

## Operators

### Arithmetical

Arithmetical operators are overloaded in Kotlin so you can use them like you would do in Javascript.

```kotlin
val syntax = js {
    val result = +JsNumber.ref("result").declare(Constant).assign((5.js - 3.js) * (10.js + 2.js))
    val text = +JsString.ref("text").declare(Constant).assign("The result is: ".js + result)
    +jsLog(text)
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
    val bool0 = +JsBoolean.ref().declare(Constant).assign(true)
    val bool1 = +JsBoolean.ref().declare(Constant).assign(false)
    val result = +JsBoolean.ref("result").declare(Constant).assign(bool0 and bool1)
    +jsLog(result)
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
    val result = +JsBoolean.ref("result").declare(Constant).assign(5.js eq 5.js)
    +jsLog(result)
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
    val bool0 = +JsBoolean.ref().declare(Constant).assign(5.js eq 5.js)
    val bool1 = +JsBoolean.ref().declare(Constant).assign(false)
    val bool2 = +JsBoolean.ref().declare(Constant).assign(true)
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

Declare collections and iterate them

```kotlin
fun main(vararg args: String) {
    val syntax = js {
        val collection = +JsCollection.ref<JsNumber>().declare(Constant).assign(
            JsCollection.value(0.js, 1.js, 2.js, 3.js, 4.js)
        )
        +collection.forEach(JsLambda.value(JsNumber.ref()) { number1 ->
            +jsLog(number1)
        })
    }
    println(syntax)
    
    // Output:
    // const collection_1 = [0, 1, 2, 3]
    // collection_1.forEach((number_2) => {
    //     console.log(number_2)
    // })    
}
```

### Declare functions

Declare functions and call them any time
```kotlin
val syntax = js {
    val greet = +JsFunction(name = "greet", JsString.ref(), JsString.ref()) { string1, string2 ->
        +jsLog(string1 + string2)
    }
    +greet("Hello, ".js, "World".js)
}
println(syntax)

// Output:
// function greet(string_1, string_2) {
//     console.log(string_1 + string_2)
// }
// greet("Hello, ", "World")
```
## Integrate with Html DSL

Javascript code can be integrated with the Html DSL using `jsScript` function

```kotlin
val showAlert = JsFunction1Ref<JsString>("showAlert")
val html = createHTML().html {
    head {
        jsScript {
            +JsFunction(name = "showAlert", JsString.ref()) {
                +JsWindowObjectRef.alert(it)
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

// Output:
// <html>
// <head>
//  <script>
//      function showAlert(string_0) {
//          window.alert(string_0)
//      }
//  </script>
// </head>
// <body>
//  <button onclick="showAlert('Hello World!')">Click me</button>
// </body>
// </html>

```

# License - MIT

Copyright 2025 Asere.net

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
