package net.asere.kthot.js.dsl.type.function.f4

import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.function.JsFunctionRef
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a reference to an async JavaScript function that takes four parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @param Param2 The type of the second parameter that the JavaScript function expects.
 * @param Param3 The type of the third parameter that the JavaScript function expects.
 * @param Param4 The type of the fourth parameter that the JavaScript function expects.
 * @param Result The type of the value that the JavaScript Promise will resolve to.
 * @property name The name of the JavaScript function.
 * @property resultTypeBuilder The builder of the result type.
 */
class JsAsyncResultFunction4Ref<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement) -> Result,
) : JsFunctionRef(name) {

    /**
     * Invokes the JavaScript function with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param1, param2, param3, param4);
     * ```
     *
     * @param param1 The [Param1] value to pass as the first argument to the function.
     * @param param2 The [Param2] value to pass as the second argument to the function.
     * @param param3 The [Param3] value to pass as the third argument to the function.
     * @param param4 The [Param4] value to pass as the fourth argument to the function.
     * @return A [JsPromise] object representing the JavaScript function call.
     */
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4) =
        JsPromise.syntax(
            value = resultTypeBuilder(InvocationOperation(this, param1, param2, param3, param4)),
            typeBuilder = resultTypeBuilder,
        )
}