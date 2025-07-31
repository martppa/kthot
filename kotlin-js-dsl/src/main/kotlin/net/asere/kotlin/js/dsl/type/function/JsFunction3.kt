@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.reference.function.JsFunction3Ref
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Defines a JavaScript function that takes three parameters.
 * This is a DSL extension function for [JsScriptScope], allowing you to declare and define
 * a new JavaScript function with three arguments.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName(param1, param2, param3) {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScriptScope] where the function is being defined.
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
        Param3Ref: JsReference<Param3>, Param3 : JsValue> JsScriptScope.Function(
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
 * Represents a JavaScript function that takes three parameters.
 * This class is used internally by the [Function] DSL extension to build the JavaScript syntax for the function.
 *
 * @param Param1Ref The type of the [JsReference] for the first parameter.
 * @param Param1 The type of the first parameter's value.
 * @param Param2Ref The type of the [JsReference] for the second parameter.
 * @param Param2 The type of the second parameter's value.
 * @param Param3Ref The type of the [JsReference] for the third parameter.
 * @param Param3 The type of the third parameter's value.
 * @param name The name of the function.
 * @param param1 The [JsDefinition] for the first parameter.
 * @param param2 The [JsDefinition] for the second parameter.
 * @param param3 The [JsDefinition] for the third parameter.
 * @param definition A lambda that defines the content of the function's body, receiving the parameters as arguments.
 */
class JsFunction3<
        Param1Ref: JsReference<Param1>, Param1 : JsValue,
        Param2Ref: JsReference<Param2>, Param2 : JsValue,
        Param3Ref: JsReference<Param3>, Param3 : JsValue>(
    name: String,
    private val param1: JsDefinition<Param1Ref, Param1>,
    private val param2: JsDefinition<Param2Ref, Param2>,
    private val param3: JsDefinition<Param3Ref, Param3>,
    private val definition: JsSyntaxScope.(
        Param1,
        Param2,
        Param3
    ) -> Unit,
) : JsFunctionCommons<JsFunction3Ref<Param1, Param2, Param3>>(name) {

    /**
     * The [JsFunction3Ref] instance that refers to this function.
     */
    override val functionRef: JsFunction3Ref<Param1, Param2, Param3> = JsFunction3Ref(name)

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