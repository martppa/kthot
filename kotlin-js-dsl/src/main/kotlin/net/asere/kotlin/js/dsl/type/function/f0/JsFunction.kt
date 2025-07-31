@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

/**
 * Defines a JavaScript function with no parameters.
 * This is a DSL extension function for [JsScriptScope], allowing you to declare and define
 * a new JavaScript function.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * function functionName() {
 * // ... function body ...
 * }
 * ```
 * @receiver The [JsScriptScope] where the function is being defined.
 * @param name The name of the function. A unique name is generated if not provided.
 * @param definition A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the function body.
 */
@JsDsl
fun JsScriptScope.Function(
    name: String = "function_${ReferenceId.nextRefInt()}",
    definition: JsSyntaxScope.() -> Unit
) = +JsFunction0(
    name = name,
    definition = definition
)

/**
 * Represents a JavaScript function that takes no parameters.
 * This class is used internally by the [net.asere.kotlin.js.dsl.type.function.f1.Function] DSL extension to build the JavaScript syntax for the function.
 *
 * @param name The name of the function.
 * @param definition A lambda that defines the content of the function's body.
 */
class JsFunction0(
    name: String,
    private val definition: JsSyntaxScope.() -> Unit,
) : net.asere.kotlin.js.dsl.type.function.JsFunctionCommons<JsFunctionRef>(name) {

    /**
     * The [JsFunctionRef] instance that refers to this function.
     */
    override val functionRef: JsFunctionRef = JsFunctionRef(name)

    /**
     * Builds the inner scope parameters for the function, applying the provided [definition] lambda
     * to a new [JsSyntaxScope].
     * @return An [InnerScopeParameters] object containing the function's body.
     */
    override fun buildScopeParameters() = InnerScopeParameters(scope = JsSyntaxScope().apply(definition))
}