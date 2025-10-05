package net.asere.kthot.js.dsl.type.lambda.l4

import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes four parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with four parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 * @param Param3 The type of the third parameter that the JavaScript lambda expects.
 * @param Param4 The type of the fourth parameter that the JavaScript lambda expects.
 */
interface JsLambda4<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> : JsValue {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3,
        param4: Param4,
    ) = InvocationOperation(this, param1, param2, param3, param4)

    companion object
}