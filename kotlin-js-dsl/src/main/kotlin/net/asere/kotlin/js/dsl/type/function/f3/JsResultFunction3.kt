@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function.f3

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsEmptySyntax
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.function.JsFunction
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

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
        > JsScope.ResultFunction3(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1, Param2, Param3) -> Result
) = +JsResultFunction3(
    name = name,
    resultTypeBuilder = { syntax ->
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
 * Represents a JavaScript function that takes three parameters and returns a result.
 * This class is used internally by the [ResultFunction3] DSL extension
 * to build the JavaScript syntax for the function.
 *
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param Result The type of the value the function returns.
 * @param name The name of the function.
 * @param param1 The [JsDefinition] for the first parameter.
 * @param param2 The [JsDefinition] for the second parameter.
 * @param param3 The [JsDefinition] for the third parameter.
 * @param definition A lambda that defines the content of the function's body, receiving the parameters as arguments and returning a [Result].
 */
class JsResultFunction3<
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Result : JsValue
        >(
    name: String,
    resultTypeBuilder: (JsElement) -> Result,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val definition: JsSyntaxScope.(Param1, Param2, Param3) -> Result,
) : JsFunction<JsResultFunction3Ref<Param1, Param2, Param3, Result>>(name) {

    /**
     * The [JsResultFunction3Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction3Ref<Param1, Param2, Param3, Result> = JsResultFunction3Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope] and passing the parameter references.
     * @return An [InnerScopeParameters] object containing the function's body and its invocation parameters.
     */
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1, param2.reference as Param2, param3.reference as Param3)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference)
    )
}