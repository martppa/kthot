package net.asere.kotlin.js.dsl.type.function.f5

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.JsFunctionRef
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a reference to an async JavaScript function that takes five parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript function expects.
 * @param Param2 The type of the second parameter that the JavaScript function expects.
 * @param Param3 The type of the third parameter that the JavaScript function expects.
 * @param Param4 The type of the fourth parameter that the JavaScript function expects.
 * @param Param5 The type of the fifth parameter that the JavaScript function expects.
 * @param Result The type of the value that the JavaScript Promise will resolve to.
 * @property name The name of the JavaScript function.
 * @property resultTypeBuilder The builder of the result type.
 */
class JsAsyncResultFunction5Ref<
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue,
        Result : JsValue>(
    name: String,
    internal val resultTypeBuilder: (JsElement, Boolean) -> Result,
) : JsFunctionRef(name) {

    /**
     * Invokes the JavaScript function with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * functionName(param1, param2, param3, param4, param5);
     * ```
     *
     * @param param1 The [Param1] value to pass as the first argument to the function.
     * @param param2 The [Param2] value to pass as the second argument to the function.
     * @param param3 The [Param3] value to pass as the third argument to the function.
     * @param param4 The [Param4] value to pass as the fourth argument to the function.
     * @param param5 The [Param5] value to pass as the fifth argument to the function.
     * @return A [JsPromise] object representing the JavaScript function call.
     */
    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4, param5: Param5) =
        JsPromise.syntax(
            value = resultTypeBuilder(InvocationOperation(this, param1, param2, param3, param4, param5), false), // TODO: Improve nullability feature toa void depending on local property 'isNullable'
            typeBuilder = resultTypeBuilder
        )
}