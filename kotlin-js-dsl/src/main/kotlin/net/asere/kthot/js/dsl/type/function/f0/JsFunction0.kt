@file:Suppress("UNCHECKED_CAST")

package net.asere.kthot.js.dsl.type.function.f0

import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.type.function.JsFunction

/**
 * Represents a JavaScript function that takes no parameters.
 * This class is used internally by the [Function0] DSL extension to build the JavaScript syntax for the function.
 *
 * @param name The name of the function.
 * @param definition A lambda that defines the content of the function's body.
 */
class JsFunction0(
    name: String,
    private val definition: JsSyntaxScope.() -> Unit,
) : JsFunction<JsFunction0Ref>(name) {

    /**
     * The [JsFunction0Ref] instance that refers to this function.
     */
    override val functionRef: JsFunction0Ref = JsFunction0Ref(name)

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope].
     * @return An [InnerScopeParameters] object containing the function's body.
     */
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))
}