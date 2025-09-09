@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function.f1

import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.function.JsFunction
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

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
class JsFunction1<Param1Ref: JsReference<Param1>, Param1 : JsValue>(
    name: String,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val definition: JsSyntaxScope.(
        Param1,
    ) -> Unit,
) : JsFunction<JsFunction1Ref<Param1>>(name) {

    /**
     * The [JsFunction1Ref] instance that refers to this function.
     */
    override val functionRef: JsFunction1Ref<Param1> = JsFunction1Ref(name)

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