package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunction
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript function that takes no parameters.
 * This class is used internally by the [ResultFunction0] DSL extension to build the JavaScript syntax for the function.
 *
 * @param name The name of the function.
 * @param resultTypeBuilder The builder for the returned type. Use the [ResultFunction0] builder if you don't know what to provide here]
 * @param definition A lambda that defines the content of the function's body.
 */
open class JsResultFunction0<Result : JsValue>(
    name: String,
    resultTypeBuilder: (JsElement) -> Result,
    private val definition: JsSyntaxScope.() -> Result,
) : JsFunction<JsResultFunction0Ref<Result>>(name) {

    /**
     * The [JsResultFunction0Ref] instance that refers to this function.
     */
    override val functionRef: JsResultFunction0Ref<Result> = JsResultFunction0Ref(
        name = name,
        resultTypeBuilder = resultTypeBuilder
    )

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope].
     * @return An [InnerScopeParameters] object containing the function's body.
     */
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply { definition() })
}