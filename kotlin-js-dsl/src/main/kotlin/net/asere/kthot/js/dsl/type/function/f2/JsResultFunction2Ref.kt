package net.asere.kthot.js.dsl.type.function.f2

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.function.JsFunctionRef
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a reference to a JavaScript function that takes two parameters and has a result.
 * This class allows you to create a Kotlin object that represents an existing JavaScript function
 * and then invoke it with two arguments, generating the corresponding JavaScript call syntax.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @param Param2 The type of the second parameter that the JavaScript function expects.
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 * @property resultTypeBuilder The builder of the result type.
 */
class JsResultFunction2Ref<Param1 : JsValue, Param2 : JsValue, Result : JsValue>(
    name: String? = null,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsFunctionRef(name) {
    /**
     * Invokes the JavaScript function with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param1, param2);
     * ```
     *
     * @param param1 The [Param1] value to pass as the first argument to the function.
     * @param param2 The [Param2] value to pass as the second argument to the function.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(param1: Param1, param2: Param2) = resultTypeBuilder(InvocationOperation(this, param1, param2))
}