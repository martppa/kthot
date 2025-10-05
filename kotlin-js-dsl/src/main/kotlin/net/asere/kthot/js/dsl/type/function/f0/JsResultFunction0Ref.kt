package net.asere.kthot.js.dsl.type.function.f0

import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.function.JsFunctionRef
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a reference to a JavaScript function that takes no parameters and returns a result.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it without arguments, generating the corresponding JavaScript call syntax.
 *
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsResultFunction0Ref<Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function without any parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName();
     * ```
     * @return A generic typed object representing the JavaScript function call.
     */
    operator fun invoke() = resultTypeBuilder(InvocationOperation(this))
}