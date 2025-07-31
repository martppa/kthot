package net.asere.kotlin.js.dsl.type.reference.function

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation

/**
 * Represents a reference to a JavaScript function that takes no parameters.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it without arguments, generating the corresponding JavaScript call syntax.
 *
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsFunctionRef(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    /**
     * Invokes the JavaScript function without any parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName();
     * ```
     * or for anonymous functions:
     * ```javascript
     * functionReference();
     * ```
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke() = JsSyntax(InvocationOperation(this))
}
