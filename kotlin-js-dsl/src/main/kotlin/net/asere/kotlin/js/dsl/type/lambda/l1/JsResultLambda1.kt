package net.asere.kotlin.js.dsl.type.lambda.l1

import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes one parameter and returns a value.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with a single parameter.
 *
 * @param Param1 The type of the single parameter that the JavaScript lambda expects.
 */
interface JsResultLambda1<Param1 : JsValue, Result : JsValue> : JsValue {

    operator fun invoke(param: Param1): Result

    companion object
}