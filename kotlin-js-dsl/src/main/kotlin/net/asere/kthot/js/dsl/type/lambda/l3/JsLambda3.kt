package net.asere.kthot.js.dsl.type.lambda.l3

import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes three parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with three parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 * @param Param3 The type of the third parameter that the JavaScript lambda expects.
 */
interface JsLambda3<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> : JsValue {

    operator fun invoke(
        param1: Param1,
        param2: Param2,
        param3: Param3
    ) = InvocationOperation(this, param1, param2, param3)

    companion object
}