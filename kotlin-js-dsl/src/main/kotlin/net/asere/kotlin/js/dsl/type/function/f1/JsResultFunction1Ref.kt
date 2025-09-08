package net.asere.kotlin.js.dsl.type.function.f1

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunctionRef
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a reference to a JavaScript function that takes one parameter.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it with a single argument, generating the corresponding JavaScript call syntax.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 */
class JsResultFunction1Ref<Param1 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function with the provided parameter.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param);
     * ```
     * or for anonymous functions:
     * ```javascript
     * functionReference(param);
     * ```
     * @param param The [Param1] value to pass as the first argument to the function.
     * @return A generic typed object representing the JavaScript function call.
     */
    operator fun invoke(param: Param1) = resultTypeBuilder(InvocationOperation(this, param))
}