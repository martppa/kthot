package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes no parameters and has a result.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function without explicit parameters.
 */
interface JsResultLambda0<Result : JsValue> : JsValue {

    operator fun invoke(): Result

    companion object
}