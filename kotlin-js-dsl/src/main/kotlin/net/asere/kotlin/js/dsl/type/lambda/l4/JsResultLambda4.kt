package net.asere.kotlin.js.dsl.type.lambda.l4

import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes four parameters and returns a value.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with four parameters and a return value.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 * @param Param3 The type of the third parameter that the JavaScript lambda expects.
 * @param Param4 The type of the fourth parameter that the JavaScript lambda expects.
 * @param Result The type of the value that the JavaScript lambda returns.
 */
interface JsResultLambda4<Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> : JsValue {

    operator fun invoke(param1: Param1, param2: Param2, param3: Param3, param4: Param4): Result

    companion object
}