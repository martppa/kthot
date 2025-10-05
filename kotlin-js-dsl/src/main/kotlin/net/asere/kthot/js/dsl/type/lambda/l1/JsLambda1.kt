package net.asere.kthot.js.dsl.type.lambda.l1

import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes one parameter.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with a single parameter.
 *
 * @param Param1 The type of the single parameter that the JavaScript lambda expects.
 */
interface JsLambda1<Param1 : JsValue> : JsValue {

    operator fun invoke(param: Param1) = InvocationOperation(this, param)

    companion object
}