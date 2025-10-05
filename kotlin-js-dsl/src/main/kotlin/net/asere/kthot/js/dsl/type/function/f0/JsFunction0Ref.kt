package net.asere.kthot.js.dsl.type.function.f0

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.function.JsFunctionRef

/**
 * Represents a reference to a JavaScript function that takes no parameters.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it without arguments, generating the corresponding JavaScript call syntax.
 *
 * @property name The name of the JavaScript function. If `null`, a sequenced name will be generated.
 */
class JsFunction0Ref(
    name: String? = null,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function without any parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName();
     * ```
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke() = InvocationOperation(this)
}
