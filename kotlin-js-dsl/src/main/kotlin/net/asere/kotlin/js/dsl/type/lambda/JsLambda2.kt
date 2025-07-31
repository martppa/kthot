package net.asere.kotlin.js.dsl.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes two parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with two parameters.
 *
 * @param Param1 The type of the first parameter that the JavaScript lambda expects.
 * @param Param2 The type of the second parameter that the JavaScript lambda expects.
 */
interface JsLambda2<Param1 : JsValue, Param2 : JsValue> : JsValue {
    /**
     * Invokes the JavaScript lambda with the provided parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * lambdaReference(param1, param2);
     * ```
     * @param param1 The [Param1] value to pass as the first argument to the lambda.
     * @param param2 The [Param2] value to pass as the second argument to the lambda.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(param1: Param1, param2: Param2) = JsSyntax(InvocationOperation(this, param1, param2))

    companion object
}