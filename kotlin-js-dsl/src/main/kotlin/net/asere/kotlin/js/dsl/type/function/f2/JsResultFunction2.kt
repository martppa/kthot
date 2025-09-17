@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function.f2

import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.function.JsFunction
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript function that takes two parameters.
 * This class is used internally by the [ResultFunction2] DSL extension to build the JavaScript syntax for the function.
 *
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param name The name of the function.
 * @param param1 The [JsDefinition] for the first parameter.
 * @param param2 The [JsDefinition] for the second parameter.
 * @param definition A lambda that defines the content of the function's body, receiving the parameters as arguments.
 */
class JsResultFunction2<Param1Ref: JsReference<Param1>, Param1 : JsValue, Param2Ref: JsReference<Param2>, Param2 : JsValue, Result : JsValue>(
    name: String,
    resultTypeBuilder: (JsElement, Boolean) -> Result,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
    ) -> Result,
) : JsFunction<JsResultFunction2Ref<Param1, Param2, Result>>(name) {

    /**
     * The [JsFunction2Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction2Ref<Param1, Param2, Result> = JsResultFunction2Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder
    )

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope] and passing the parameter references.
     * @return An [InnerScopeParameters] object containing the function's body and its invocation parameters.
     */
    override fun buildScopeParameters() = InnerScopeParameters(
        scope = JsSyntaxScope().apply {
            definition(this, param1.reference as Param1, param2.reference as Param2)
        },
        invocationParameters = listOf(param1.reference, param2.reference)
    )
}