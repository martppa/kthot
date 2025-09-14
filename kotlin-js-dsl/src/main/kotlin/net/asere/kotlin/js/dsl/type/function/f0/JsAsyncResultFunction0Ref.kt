package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunctionRef
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a reference to an async JavaScript function that takes no parameters.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it without arguments, generating the corresponding JavaScript call syntax.
 *
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsAsyncResultFunction0Ref<Result : JsValue>(
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
     * @return A [JsPromise] object representing the JavaScript function call.
     */
    operator fun invoke() = JsPromise.syntax<Result>(resultTypeBuilder(InvocationOperation(this)))
}