# kotlin-js-dsl ![](https://img.shields.io/badge/jsDsl_version-0.0.1-004475)
This semi-typed DSL is intended to help kotlin developers write, reuse and interact with Javascript. This tool is currently under development and it's in an experimental stage.

## Installation
In order to include the DSL, add the following dependencies to your project build.gradle file:
```groovy
dependencies {
    implementation "net.asere.kotlin:js-dsl:0.0.1"
    implementation "net.asere.kotlin:js-dsl-html:0.0.1"
}
```

## Usage

The DSL is currently capable of offering some basic functionalities

### Variable definition

Define a basic string variable. `JsString` is the Kotlin representation for the `String` type in Javascript. Use the `js` function to generate the syntax. `js` function will pack all instructions and return them as a single `JsSyntax` object. Use the unary plus (+) operator to "print" any `JsElement` on the scope of `js` function's lambda.

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

In order to assign values to a JavaScript object use the `assign` extension function

```kotlin
val syntax = js {
    +JsString.ref().declare(Mutable).assign("Juan".js)
}
println(syntax) // --> let string_1 = "Juan"
```

### Referencing objects in Kotlin

Declare reference objects to deal with them at any time

```kotlin
val syntax = js {
    val stringValue = +JsString.ref().declare(Mutable).assign("Juan".js)
    +jsLog(stringValue.charAt(0.js))
}
println(syntax)

// Output:
// let string_1 = "Juan"
// console.log(string_1.charAt(0))
```
### Collections

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
    +greet(JsString.value("Hello, "), JsString.value("World"))
}
println(syntax)

// Output
// function greet(string_1, string_2) {
//     console.log(string_1 + string_2)
// }
// greet("Hello, ", "World")
```

# License - MIT

Copyright 2025 Asere.net

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
