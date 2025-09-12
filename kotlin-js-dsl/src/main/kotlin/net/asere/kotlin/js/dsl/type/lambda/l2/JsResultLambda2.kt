package net.asere.kotlin.js.dsl.type.lambda.l2

import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes two parameters and returns a value.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with two parameters and a return value.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 * @param Result The type of the value that the JavaScript lambda returns.
 */
interface JsResultLambda2<Param1 : JsValue, Param2 : JsValue, Result : JsValue> : JsValue {

    operator fun invoke(param1: Param1, param2: Param2): Result

    companion object
}