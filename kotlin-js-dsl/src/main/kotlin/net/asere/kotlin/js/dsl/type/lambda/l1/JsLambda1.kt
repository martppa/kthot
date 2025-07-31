package net.asere.kotlin.js.dsl.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes one parameter.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function with a single parameter.
 *
 * @param Param1 The type of the single parameter that the JavaScript lambda expects.
 */
interface JsLambda1<Param1 : JsValue> : JsValue {
    /**
     * Invokes the JavaScript lambda with the provided parameter.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * lambdaReference(param);
     * ```
     * @param param The [Param1] value to pass as the single argument to the lambda.
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke(param: Param1) = JsSyntax(InvocationOperation(this, param))

    companion object
}