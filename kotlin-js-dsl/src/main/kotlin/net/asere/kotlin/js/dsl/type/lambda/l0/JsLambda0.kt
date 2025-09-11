package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes no parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function without explicit parameters.
 */
interface JsLambda0 : JsValue {

    operator fun invoke(): InvocationOperation = InvocationOperation(this)

    companion object
}