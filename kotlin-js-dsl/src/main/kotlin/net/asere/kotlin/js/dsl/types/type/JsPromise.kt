package net.asere.kotlin.js.dsl.types.type

import net.asere.kotlin.js.dsl.syntax.instantiation.Instantiable
import net.asere.kotlin.js.dsl.syntax.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation
import net.asere.kotlin.js.dsl.syntax.value.JsPromiseSyntax
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

/**
 * Represents a JavaScript `Promise` object.
 * This is a generic interface as Promises can resolve to various types.
 *
 * A `Promise` object represents the eventual completion (or failure) of an asynchronous operation
 * and its resulting value.
 *
 * @param T The type of [JsValue] that the Promise will resolve to upon successful completion.
 */
interface JsPromise<T : JsValue> : JsObject, Instantiable {
    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles only the fulfillment (success) case.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled)`.
     * @param onFulfilled A [JsLambda1] that is called when the Promise is fulfilled.
     * The lambda receives the fulfilled value of the Promise as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` (or the original value if `onFulfilled` is not a function).
     */
    fun then(onFulfilled: JsLambda1<T>): JsPromise<T> =
        JsPromiseSyntax(ChainOperation(this, InvocationOperation("then", onFulfilled)))

    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles both fulfillment (success) and rejection (failure) cases.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled, onRejected)`.
     * @param onFulfilled A [JsLambda1] that is called when the Promise is fulfilled.
     * The lambda receives the fulfilled value of the Promise as its single argument.
     * @param onRejected A [JsLambda1] that is called when the Promise is rejected.
     * The lambda receives the reason for rejection (error) as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` or `onRejected`.
     */
    fun then(onFulfilled: JsLambda1<T>, onRejected: JsLambda1<JsValue>): JsPromise<JsValue> =
        JsPromiseSyntax(ChainOperation(this, InvocationOperation("then", onFulfilled, onRejected)))

    /**
     * Attaches a callback for only the rejection (failure) of the Promise.
     * This is equivalent to calling `then(null, onRejected)`.
     *
     * In JavaScript, this corresponds to `promise.catch(onRejected)`.
     * @param onRejected A [JsLambda1] that is called when the Promise is rejected.
     * The lambda receives the reason for rejection (error) as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onRejected` if the Promise is rejected.
     */
    fun `catch`(onRejected: JsLambda1<JsValue>): JsPromise<JsValue> =
        JsPromiseSyntax(ChainOperation(this, InvocationOperation("catch", onRejected)))

    /**
     * Attaches a callback that is invoked when the Promise is settled (either fulfilled or rejected).
     * The callback function takes no arguments.
     *
     * In JavaScript, this corresponds to `promise.finally(onFinally)`.
     * @param onFinally A [JsLambda] that is called when the Promise is settled.
     * @return A new [JsPromise] that resolves with the same value or rejection reason as the original Promise.
     */
    fun `finally`(onFinally: JsLambda): JsPromise<JsValue> =
        JsPromiseSyntax(ChainOperation(this, InvocationOperation("finally", onFinally)))

    companion object
}