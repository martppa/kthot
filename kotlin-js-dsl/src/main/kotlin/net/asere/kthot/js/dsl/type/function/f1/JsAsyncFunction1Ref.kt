package net.asere.kthot.js.dsl.type.function.f1

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.function.JsFunctionRef
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a reference to a JavaScript async function that takes one parameter.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it with a single argument, generating the corresponding JavaScript call syntax.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsAsyncFunction1Ref<Param1 : JsValue>(
    name: String? = null,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function with the provided parameter.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * async functionName(param);
     * ```
     *
     * @param param The [Param1] value to pass as the first argument to the function.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(param: Param1) = JsPromise.syntax<JsNothing>(
        value = InvocationOperation(this, param), isNullable = false
    )
}