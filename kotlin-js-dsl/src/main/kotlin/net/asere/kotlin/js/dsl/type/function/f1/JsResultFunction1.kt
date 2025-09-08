@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function.f1

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
 * @param resultTypeBuilder The builder for the returned type. It's set by default to be provided. Specify a value if you wish a custom one
 * @param definition A lambda with receiver [JsSyntaxScope] and the first parameter [Param1] as an argument,
 * to define the JavaScript code inside the function body.
 */
@JsDsl
inline fun <Param1Ref: JsReference<Param1>, reified Param1 : JsValue, reified Result : JsValue> JsScope.ResultFunction1(
    name: String = "function_${ReferenceId.nextRefInt()}",
    param1: JsDefinition<Param1Ref, Param1>,
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1) -> Result
) = +JsResultFunction1(
    name = name,
    resultTypeBuilder = { syntax ->
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
 * Represents a JavaScript function that takes one parameter.
 * This class is used internally by the [net.asere.kotlin.js.dsl.type.lambda.l0.Function] DSL extension to build the JavaScript syntax for the function.
 *
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param name The name of the function.
 * @param param1 The [JsDefinition] for the first parameter.
 * @param definition A lambda that defines the content of the function's body, receiving the parameter as an argument.
 */
class JsResultFunction1<Param1Ref: JsReference<Param1>, Param1 : JsValue, Result : JsValue>(
    name: String,
    resultTypeBuilder: (JsElement) -> Result,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val definition: JsSyntaxScope.(Param1) -> Result,
) : JsFunction<JsResultFunction1Ref<Param1, Result>>(name) {

    /**
     * The [JsResultFunction1Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction1Ref<Param1, Result> = JsResultFunction1Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder,
    )

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope] and passing the parameter reference.
     * @return An [InnerScopeParameters] object containing the function's body and its invocation parameters.
     */
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1)
        },
        invocationParameters = listOf(param1.reference)
    )
}