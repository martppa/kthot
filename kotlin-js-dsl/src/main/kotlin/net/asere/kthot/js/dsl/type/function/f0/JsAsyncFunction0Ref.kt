package net.asere.kthot.js.dsl.type.function.f0

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.function.JsFunctionRef
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax

/**
 * Represents a reference to an async JavaScript function that takes no parameters.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it without arguments, generating the corresponding JavaScript call syntax.
 *
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsAsyncFunction0Ref(
    name: String? = null,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function without any parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * async functionName();
     * ```
     * @return A [JsPromise] object representing the JavaScript function call.
     */
    operator fun invoke(): JsPromise<JsNothing> = JsPromise.syntax(InvocationOperation(this))
}