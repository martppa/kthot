package net.asere.kotlin.js.dsl.type.function

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsEmptySyntax
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.syntax.jsreturn.Return
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.function.f0.JsAsyncFunction0Ref
import net.asere.kotlin.js.dsl.type.function.f0.JsAsyncResultFunction0Ref
import net.asere.kotlin.js.dsl.type.function.f0.JsFunction0
import net.asere.kotlin.js.dsl.type.function.f0.JsResultFunction0
import net.asere.kotlin.js.dsl.type.function.f1.JsAsyncFunction1Ref
import net.asere.kotlin.js.dsl.type.function.f1.JsAsyncResultFunction1Ref
import net.asere.kotlin.js.dsl.type.function.f1.JsFunction1
import net.asere.kotlin.js.dsl.type.function.f1.JsResultFunction1
import net.asere.kotlin.js.dsl.type.function.f2.JsAsyncFunction2Ref
import net.asere.kotlin.js.dsl.type.function.f2.JsAsyncResultFunction2Ref
import net.asere.kotlin.js.dsl.type.function.f2.JsFunction2
import net.asere.kotlin.js.dsl.type.function.f2.JsResultFunction2
import net.asere.kotlin.js.dsl.type.function.f3.JsAsyncFunction3Ref
import net.asere.kotlin.js.dsl.type.function.f3.JsAsyncResultFunction3Ref
import net.asere.kotlin.js.dsl.type.function.f3.JsFunction3
import net.asere.kotlin.js.dsl.type.function.f3.JsResultFunction3
import net.asere.kotlin.js.dsl.type.function.f4.JsAsyncFunction4Ref
import net.asere.kotlin.js.dsl.type.function.f4.JsAsyncResultFunction4Ref
import net.asere.kotlin.js.dsl.type.function.f4.JsFunction4
import net.asere.kotlin.js.dsl.type.function.f4.JsResultFunction4
import net.asere.kotlin.js.dsl.type.function.f5.JsAsyncFunction5Ref
import net.asere.kotlin.js.dsl.type.function.f5.JsAsyncResultFunction5Ref
import net.asere.kotlin.js.dsl.type.function.f5.JsFunction5
import net.asere.kotlin.js.dsl.type.function.f5.JsResultFunction5
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Defines a JavaScript function with no parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName() {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body.
 */
@JsDsl
fun JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    definition: JsSyntaxScope.() -> Unit
) = +JsFunction0(
    name = name,
    definition = definition
)

/**
 * Defines a JavaScript function with no parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName() {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <reified Result : JsValue> JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.() -> Result
) = +JsResultFunction0(
    name = name,
    resultTypeBuilder = { syntax, _ ->
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition() }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    definition = definition
)

/**
 * Defines a JavaScript function that takes one parameter.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with a single argument.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter, allowing its name and type to be specified.
 * @param definition A lambda with receiver [JsSyntaxScope] and the first parameter [Param1] as an argument,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <Param1Ref: JsReference<Param1>, Param1 : JsValue> JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(
        Param1
    ) -> Unit
) = +JsFunction1(
    name = name,
    param1 = param1,
    definition = definition
)

/**
 * Defines a JavaScript function that takes one parameter and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with a single argument and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter, allowing its name and type to be specified.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and the first parameter [Param1] as an argument,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <Param1Ref: JsReference<Param1>, reified Param1 : JsValue, reified Result : JsValue> JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1) -> Result
) = +JsResultFunction1(
    name = name,
    resultTypeBuilder = { syntax, _ ->
        val param1Builder: (JsElement, Boolean) -> Param1 = ::provide
        val param1: Param1 = param1Builder(JsEmptySyntax, false)
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition(param1) }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    param1 = param1,
    definition = definition
)

/**
 * Defines a JavaScript function that takes two parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with two arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and both parameters [Param1], [Param2] as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <Param1Ref: JsReference<Param1>, Param1 : JsValue, Param2Ref: JsReference<Param2>, Param2 : JsValue> JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(
        Param1, Param2
    ) -> Unit
) = +JsFunction2(
    name = name,
    param1 = param1,
    param2 = param2,
    definition = definition
)

/**
 * Defines a JavaScript function that takes two parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with two arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and both parameters [Param1], [Param2] as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <Param1Ref: JsReference<Param1>, reified Param1 : JsValue, Param2Ref: JsReference<Param2>, reified Param2 : JsValue, reified Result : JsValue> JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(
        Param1, Param2
    ) -> Result
) = +JsResultFunction2(
    name = name,
    resultTypeBuilder = { syntax, _ ->
        val param1Builder: (JsElement, Boolean) -> Param1 = ::provide
        val param1: Param1 = param1Builder(JsEmptySyntax, false)
        val param2Builder: (JsElement, Boolean) -> Param2 = ::provide
        val param2: Param2 = param2Builder(JsEmptySyntax, false)
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition(param1, param2) }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    param1 = param1,
    param2 = param2,
    definition = definition
)

/**
 * Defines a JavaScript function that takes three parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with three arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all three parameters [Param1], [Param2], [Param3] as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue> JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3
    ) -> Unit
) = +JsFunction3(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)

/**
 * Defines a JavaScript function that takes three parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with three arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all three parameters [Param1], [Param2], [Param3] as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref : JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref : JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref : JsReference<Param3>, reified Param3 : JsValue,
        reified Result : JsValue
        > JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1, Param2, Param3) -> Result
) = +JsResultFunction3(
    name = name,
    resultTypeBuilder = { syntax, _ ->
        val param1Builder: (JsElement, Boolean) -> Param1 = ::provide
        val param2Builder: (JsElement, Boolean) -> Param2 = ::provide
        val param3Builder: (JsElement, Boolean) -> Param3 = ::provide
        val param1: Param1 = param1Builder(JsEmptySyntax, false)
        val param2: Param2 = param2Builder(JsEmptySyntax, false)
        val param3: Param3 = param3Builder(JsEmptySyntax, false)
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition(param1, param2, param3) }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)

/**
 * Defines a JavaScript function that takes four parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with four arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3, param4) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all four parameters as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue> JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4
    ) -> Unit
) = +JsFunction4(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    definition = definition
)

/**
 * Defines a JavaScript function that takes four parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with four arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3, param4) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all four parameters as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref: JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref: JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref: JsReference<Param3>, reified Param3 : JsValue,
        Param4Ref: JsReference<Param4>, reified Param4 : JsValue,
        reified Result : JsValue
        > JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1, Param2, Param3, Param4) -> Result
) = +JsResultFunction4(
    name = name,
    resultTypeBuilder = { syntax ->
        val param1Builder: (JsElement, Boolean) -> Param1 = ::provide
        val param2Builder: (JsElement, Boolean) -> Param2 = ::provide
        val param3Builder: (JsElement, Boolean) -> Param3 = ::provide
        val param4Builder: (JsElement, Boolean) -> Param4 = ::provide
        val param1: Param1 = param1Builder(JsEmptySyntax, false)
        val param2: Param2 = param2Builder(JsEmptySyntax, false)
        val param3: Param3 = param3Builder(JsEmptySyntax, false)
        val param4: Param4 = param4Builder(JsEmptySyntax, false)
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition(param1, param2, param3, param4) }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    definition = definition
)

/**
 * Defines a JavaScript function that takes five parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with five arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3, param4, param5) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Param5Ref The type of the [JsReference] for the fifth parameter.
 * @param Param5 The type of the fifth parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all five parameters as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue,
        Param5Ref: JsReference<Param5>, Param5 : JsValue> JsScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4,
        Param5
    ) -> Unit
) = +JsFunction5(
    name = name,
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    definition = definition
)

/**
 * Defines a JavaScript function that takes five parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript function with five arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3, param4, param5) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Param5Ref The type of the [JsReference] for the fifth parameter.
 * @param Param5 The type of the fifth parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all five parameters as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref: JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref: JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref: JsReference<Param3>, reified Param3 : JsValue,
        Param4Ref: JsReference<Param4>, reified Param4 : JsValue,
        Param5Ref: JsReference<Param5>, reified Param5 : JsValue,
        reified Result : JsValue> JsScope.ResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1, Param2, Param3, Param4, Param5) -> Result
) = +JsResultFunction5(
    name = name,
    resultTypeBuilder = { syntax, _ ->
        val param1Builder: (JsElement, Boolean) -> Param1 = ::provide
        val param2Builder: (JsElement, Boolean) -> Param2 = ::provide
        val param3Builder: (JsElement, Boolean) -> Param3 = ::provide
        val param4Builder: (JsElement, Boolean) -> Param4 = ::provide
        val param5Builder: (JsElement, Boolean) -> Param5 = ::provide
        val param1: Param1 = param1Builder(JsEmptySyntax, false)
        val param2: Param2 = param2Builder(JsEmptySyntax, false)
        val param3: Param3 = param3Builder(JsEmptySyntax, false)
        val param4: Param4 = param4Builder(JsEmptySyntax, false)
        val param5: Param5 = param5Builder(JsEmptySyntax, false)
        resultTypeBuilder(
            syntax,
            with(JsSyntaxScope().run { definition(param1, param2, param3, param4, param5) }) {
                this is JsReference<*> && this.isNullable
            }
        )
    },
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    definition = definition
)

/**
 * Defines a JavaScript async function with no parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName() {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body.
 */
@JsDsl
fun JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    definition: JsSyntaxScope.() -> Unit
): JsAsyncFunction0Ref {
    val scope = JsSyntaxScope()
    scope.run {
        Function {
            definition()
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction0Ref(name = name)
}

/**
 * Defines a JavaScript async function with no parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName() {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <reified Result : JsValue> JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.() -> Result,
): JsAsyncResultFunction0Ref<Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction<Result> {
            Return { definition() }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction0Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}

/**
 * Defines a JavaScript async function that takes one parameter.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with a single argument.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter, allowing its name and type to be specified.
 * @param definition A lambda with receiver [JsSyntaxScope] and the first parameter [Param1] as an argument,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <Param1Ref: JsReference<Param1>, Param1 : JsValue> JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(
        Param1
    ) -> Unit
): JsAsyncFunction1Ref<Param1> {
    val scope = JsSyntaxScope()
    scope.run {
        Function(param1 = param1) {
            definition(this, it)
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction1Ref(name = name)
}

/**
 * Defines a JavaScript async function that takes one parameter and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with a single argument and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter, allowing its name and type to be specified.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and the first parameter [Param1] as an argument,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <Param1Ref: JsReference<Param1>, reified Param1 : JsValue, reified Result : JsValue> JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.(Param1) -> Result,
): JsAsyncResultFunction1Ref<Param1, Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction(param1 = param1) {
            Return { definition(this, it) }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction1Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}

/**
 * Defines a JavaScript async function that takes two parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with two arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and both parameters [Param1], [Param2] as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue> JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
    ) -> Unit
): JsAsyncFunction2Ref<Param1, Param2> {
    val scope = JsSyntaxScope()
    scope.run {
        Function(param1 = param1, param2 = param2) { p1, p2 ->
            definition(this, p1, p2)
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction2Ref(name = name)
}

/**
 * Defines a JavaScript async function that takes two parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with two arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and both parameters [Param1], [Param2] as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <Param1Ref : JsReference<Param1>, reified Param1 : JsValue, Param2Ref : JsReference<Param2>, reified Param2 : JsValue, reified Result : JsValue> JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.(Param1, Param2) -> Result,
): JsAsyncResultFunction2Ref<Param1, Param2, Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction(param1 = param1, param2 = param2) { p1, p2 ->
            Return { definition(this, p1, p2) }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction2Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}

/**
 * Defines a JavaScript async function that takes three parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with three arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all three parameters [Param1], [Param2], [Param3] as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue
        > JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
    ) -> Unit
): JsAsyncFunction3Ref<Param1, Param2, Param3> {
    val scope = JsSyntaxScope()
    scope.run {
        Function(param1 = param1, param2 = param2, param3 = param3) { p1, p2, p3 ->
            definition(this, p1, p2, p3)
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction3Ref(name = name)
}

/**
 * Defines a JavaScript async function that takes three parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with three arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all three parameters [Param1], [Param2], [Param3] as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref : JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref : JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref : JsReference<Param3>, reified Param3 : JsValue,
        reified Result : JsValue
        > JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.(Param1, Param2, Param3) -> Result,
): JsAsyncResultFunction3Ref<Param1, Param2, Param3, Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction(param1 = param1, param2 = param2, param3 = param3) { p1, p2, p3 ->
            Return { definition(this, p1, p2, p3) }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction3Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}

/**
 * Defines a JavaScript async function that takes four parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with four arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3, param4) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all four parameters as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue
        > JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4,
    ) -> Unit
): JsAsyncFunction4Ref<Param1, Param2, Param3, Param4> {
    val scope = JsSyntaxScope()
    scope.run {
        Function(param1 = param1, param2 = param2, param3 = param3, param4 = param4) { p1, p2, p3, p4 ->
            definition(this, p1, p2, p3, p4)
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction4Ref(name = name)
}

/**
 * Defines a JavaScript async function that takes four parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with four arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3, param4) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all four parameters as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref : JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref : JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref : JsReference<Param3>, reified Param3 : JsValue,
        Param4Ref : JsReference<Param4>, reified Param4 : JsValue,
        reified Result : JsValue
        > JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.(Param1, Param2, Param3, Param4) -> Result,
): JsAsyncResultFunction4Ref<Param1, Param2, Param3, Param4, Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction(param1 = param1, param2 = param2, param3 = param3, param4 = param4) { p1, p2, p3, p4 ->
            Return { definition(this, p1, p2, p3, p4) }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction4Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}

/**
 * Defines a JavaScript async function that takes five parameters.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with five arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3, param4, param5) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Param5Ref The type of the [JsReference] for the fifth parameter.
 * @param Param5 The type of the fifth parameter's value.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param definition A lambda with receiver [JsSyntaxScope] and all five parameters as arguments,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        Param5Ref : JsReference<Param5>, Param5 : JsValue
        > JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3,
        Param4,
        Param5,
    ) -> Unit
): JsAsyncFunction5Ref<Param1, Param2, Param3, Param4, Param5> {
    val scope = JsSyntaxScope()
    scope.run {
        Function(param1 = param1, param2 = param2, param3 = param3, param4 = param4, param5 = param5) { p1, p2, p3, p4, p5 ->
            definition(this, p1, p2, p3, p4, p5)
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction5Ref(name = name)
}

/**
 * Defines a JavaScript async function that takes five parameters and returns a result.
 * This is a DSL extension function for [JsScope], allowing you to declare and define
 * a new JavaScript async function with five arguments and a specific return type.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * async function functionName(param1, param2, param3, param4, param5) {
 * // ... function body ...
 * // return aResult;
 * }
 * ```
 * @receiver The [JsScope] where the function is being defined.
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Param4Ref The type of the [JsReference] for the fourth parameter.
 * @param Param4 The type of the fourth parameter's value.
 * @param Param5Ref The type of the [JsReference] for the fifth parameter.
 * @param Param5 The type of the fifth parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and all five parameters as arguments,
 * to define the JavaScript code inside the function body. The lambda must return a [Result] value.
 */
@JsDsl
inline fun <
        Param1Ref : JsReference<Param1>, reified Param1 : JsValue,
        Param2Ref : JsReference<Param2>, reified Param2 : JsValue,
        Param3Ref : JsReference<Param3>, reified Param3 : JsValue,
        Param4Ref : JsReference<Param4>, reified Param4 : JsValue,
        Param5Ref : JsReference<Param5>, reified Param5 : JsValue,
        reified Result : JsValue
        > JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.(Param1, Param2, Param3, Param4, Param5) -> Result,
): JsAsyncResultFunction5Ref<Param1, Param2, Param3, Param4, Param5, Result> {
    val scope = JsSyntaxScope()
    val result = scope.run {
        ResultFunction(param1 = param1, param2 = param2, param3 = param3, param4 = param4, param5 = param5) { p1, p2, p3, p4, p5 ->
            Return { definition(this, p1, p2, p3, p4, p5) }
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction5Ref(
        name = name,
        resultTypeBuilder = { syntax, _ ->
            resultTypeBuilder(
                syntax,
                result.isNullable
            )
        },
    )
}
