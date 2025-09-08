package net.asere.kotlin.js.dsl.type.function.f3

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunctionRef
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a reference to a JavaScript function that takes three parameters and has a result.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @param Param2 The type of the second parameter that the JavaScript function expects.
 * @param Param3 The type of the third parameter that the JavaScript function expects.
 * @param Result The type of the value that the JavaScript function returns.
 * @property name The name of the JavaScript function. If `null`, it implies an anonymous function or a reference passed by other means.
 * @property resultTypeBuilder The builder of the result type.
 */
class JsResultFunction3Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Result : JsValue>(
    name: String? = null,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsFunctionRef(name) {

    /**
     * Invokes the JavaScript function with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param1, param2, param3);
     * ```
     *
     * @param param1 The [Param1] value to pass as the first argument to the function.
     * @param param2 The [Param2] value to pass as the second argument to the function.
     * @param param3 The [Param3] value to pass as the third argument to the function.
     * @return A [Result] object representing the JavaScript function call and its return value.
     */
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3) =
        resultTypeBuilder(InvocationOperation(this, param1, param2, param3))
}