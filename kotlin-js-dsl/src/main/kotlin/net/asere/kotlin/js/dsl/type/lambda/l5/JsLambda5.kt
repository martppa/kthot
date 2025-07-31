package net.asere.kotlin.js.dsl.type.lambda.l5

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes five parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with five parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 * @param Param3 The type of the third parameter that the JavaScript lambda expects.
 * @param Param4 The type of the fourth parameter that the JavaScript lambda expects.
 * @param Param5 The type of the fifth parameter that the JavaScript lambda expects.
 */
interface JsLambda5<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Param5 : JsValue> :
    JsValue {
    /**
     * Invokes the JavaScript lambda with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * lambdaReference(param1, param2, param3, param4, param5);
     * ```
     * @param param1 The [Param1] value to pass as the first argument to the lambda.
     * @param param2 The [Param2] value to pass as the second argument to the lambda.
     * @param param3 The [Param3] value to pass as the third argument to the lambda.
     * @param param4 The [Param4] value to pass as the fourth argument to the lambda.
     * @param param5 The [Param5] value to pass as the fifth argument to the lambda.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
        param5: Param5,
    ) = JsSyntax(InvocationOperation(this, param1, param2, param3, param4, param5))

    companion object
}