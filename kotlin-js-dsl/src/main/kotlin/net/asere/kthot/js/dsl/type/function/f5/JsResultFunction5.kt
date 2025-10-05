@file:Suppress("UNCHECKED_CAST")

package net.asere.kthot.js.dsl.type.function.f5

import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.function.JsFunction
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript function that takes five parameters and returns a result.
 * This class is used internally by the [net.asere.kthot.js.dsl.type.lambda.l5.ResultFunction5] DSL extension
 * to build the JavaScript syntax for the function.
 *
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
 * @param name The name of the function.
 * @param param1 The [JsDefinition] for the first parameter.
 * @param param2 The [JsDefinition] for the second parameter.
 * @param param3 The [JsDefinition] for the third parameter.
 * @param param4 The [JsDefinition] for the fourth parameter.
 * @param param5 The [JsDefinition] for the fifth parameter.
 * @param definition A lambda that defines the content of the function's body, receiving the parameters as arguments and returning a [Result].
 */
class JsResultFunction5<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue,
        Param4Ref: JsReference<Param4>, Param4 : JsValue,
        Param5Ref: JsReference<Param5>, Param5 : JsValue,
        Result : JsValue
        >(
    name: String,
    resultTypeBuilder: (JsElement) -> Result,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val param4: JsDefinition<Param4Ref, Param4>,
    private val param5: JsDefinition<Param5Ref, Param5>,
    private val definition: JsSyntaxScope.(Param1, Param2, Param3, Param4, Param5) -> Result,
) : JsFunction<JsResultFunction5Ref<Param1, Param2, Param3, Param4, Param5, Result>>(name) {

    /**
     * The [JsResultFunction5Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction5Ref<Param1, Param2, Param3, Param4, Param5, Result> = JsResultFunction5Ref(
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
            definition(this, param1.reference as Param1, param2.reference as Param2, param3.reference as Param3, param4.reference as Param4, param5.reference as Param5)
        },
        invocationParameters = listOf(param1.reference, param2.reference, param3.reference, param4.reference, param5.reference)
    )
}