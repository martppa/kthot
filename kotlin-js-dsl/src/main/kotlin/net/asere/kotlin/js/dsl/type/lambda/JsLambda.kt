package net.asere.kotlin.js.dsl.type.lambda

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript lambda (anonymous function) that takes no parameters.
 * This interface can be implemented by classes that need to act as a callable
 * JavaScript function without explicit parameters.
 */
interface JsLambda : JsValue {
    /**
     * Invokes the JavaScript lambda without any parameters.
     *
     * In JavaScript, this corresponds to:
     * ```javascript
     * lambdaReference();
     * ```
     * @return A [JsSyntax] object representing the JavaScript function call.
     */
    operator fun invoke() = JsSyntax(InvocationOperation(this))

    companion object
}