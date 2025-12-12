@file:OptIn(JsInternalApi::class)

package net.asere.kthot.js.dsl.type.promise

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.async.JsAsyncCallable
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.error.ref
import net.asere.kthot.js.dsl.type.lambda.l0.JsLambda0
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.value.JsValue

/**
 * Represents a JavaScript `Promise` object.
 * This is a generic interface as Promises can resolve to various types.
 *
 * A `Promise` object represents the eventual completion (or failure) of an asynchronous operation
 * and its resulting value.
 *
 * @param T The type of [JsValue] that the Promise will resolve to upon successful completion.
 */
interface JsPromise<T : JsValue> : JsObject, JsAsyncCallable {

    @JsInternalApi
    val _typeBuilder_: (JsElement) -> T

    /**
     * Attaches callbacks for the resolution of the Promise.
     * This version handles parameter.
     *
     * In JavaScript, this corresponds to `promise.then()`.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` (or the original value if `onFulfilled` is not a function).
     */
    fun then(): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then")),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles only the fulfillment (success) case.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled)`.
     * @param onFulfilled A Kotlin lambda that is "called" when the Promise is fulfilled.
     * The lambda receives the fulfilled value of the Promise as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` (or the original value if `onFulfilled` is not a function).
     */
    fun then(onFulfilled: JsScope.(T) -> Unit): JsPromise<T> {
        val scope = JsSyntaxScope()
        onFulfilled(scope, _typeBuilder_(JsSyntax("value")))
        return JsPromise.syntax(
            value = ChainOperation(
                this, InvocationOperation(
                    leftSideElement = "then", onFulfilled.js(_typeBuilder_)
                )
            ),
            typeBuilder = _typeBuilder_
        )
    }

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
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then", onFulfilled)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles only the fulfillment (success) case.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled)`.
     * @param onFulfilled A [JsLambda0] that is called when the Promise is fulfilled.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` (or the original value if `onFulfilled` is not a function).
     */
    fun then(onFulfilled: JsLambda0): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then", onFulfilled)),
            typeBuilder = _typeBuilder_
        )

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
    fun then(onFulfilled: JsLambda1<T>, onRejected: JsLambda1<JsError>): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then", onFulfilled, onRejected)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles both fulfillment (success) and rejection (failure) cases.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled, onRejected)`.
     * @param onFulfilled A [JsLambda0] that is called when the Promise is fulfilled.
     * @param onRejected A [JsLambda1] that is called when the Promise is rejected.
     * The lambda receives the reason for rejection (error) as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` or `onRejected`.
     */
    fun then(onFulfilled: JsLambda0, onRejected: JsLambda1<JsError>): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then", onFulfilled, onRejected)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches callbacks for the resolution and/or rejection of the Promise.
     * This version handles both fulfillment (success) and rejection (failure) cases.
     *
     * In JavaScript, this corresponds to `promise.then(onFulfilled, onRejected)`.
     * @param onFulfilled A [JsLambda0] that is called when the Promise is fulfilled.
     * @param onRejected A [JsLambda0] that is called when the Promise is rejected.
     * @return A new [JsPromise] that resolves with the return value of `onFulfilled` or `onRejected`.
     */
    fun then(onFulfilled: JsLambda0, onRejected: JsLambda0): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("then", onFulfilled, onRejected)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches a callback for only the rejection (failure) of the Promise.
     * This is equivalent to calling `then(null, onRejected)`.
     *
     * In JavaScript, this corresponds to `promise.catch(onRejected)`.
     * @param onRejected A [JsLambda1] that is called when the Promise is rejected.
     * The lambda receives the reason for rejection (error) as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onRejected` if the Promise is rejected.
     */
    fun onCatch(onRejected: JsLambda1<JsError>): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("catch", onRejected)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches a callback for only the rejection (failure) of the Promise.
     * This is equivalent to calling `then(null, onRejected)`.
     *
     * In JavaScript, this corresponds to `promise.catch(onRejected)`.
     * @param onRejected A [JsLambda1] that is called when the Promise is rejected.
     * The lambda receives the reason for rejection (error) as its single argument.
     * @return A new [JsPromise] that resolves with the return value of `onRejected` if the Promise is rejected.
     */
    fun onCatch(onRejected: JsScope.(JsError) -> Unit): JsPromise<T> {
        val scope = JsSyntaxScope()
        onRejected(scope, JsError.ref("error"))
        return JsPromise.syntax(
            value = ChainOperation(
                this, InvocationOperation(
                    leftSideElement = "catch", onRejected.js
                )
            ),
            typeBuilder = _typeBuilder_
        )
    }

    /**
     * Attaches a callback for only the rejection (failure) of the Promise.
     * This is equivalent to calling `then(null, onRejected)`.
     *
     * In JavaScript, this corresponds to `promise.catch(onRejected)`.
     * @param onRejected A [JsLambda0] that is called when the Promise is rejected.
     * @return A new [JsPromise] that resolves with the return value of `onRejected` if the Promise is rejected.
     */
    fun onCatch(onRejected: JsLambda0): JsPromise<T> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("catch", onRejected)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches a callback that is invoked when the Promise is settled (either fulfilled or rejected).
     * The callback function takes no arguments.
     *
     * In JavaScript, this corresponds to `promise.finally(onFinally)`.
     * @param onFinally A [JsLambda0] that is called when the Promise is settled.
     * @return A new [JsPromise] that resolves with the same value or rejection reason as the original Promise.
     */
    fun doFinally(onFinally: JsLambda0): JsPromise<JsValue> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("finally", onFinally)),
            typeBuilder = _typeBuilder_
        )

    /**
     * Attaches a callback that is invoked when the Promise is settled (either fulfilled or rejected).
     * The callback function takes no arguments.
     *
     * In JavaScript, this corresponds to `promise.finally(onFinally)`.
     * @param onFinally A [JsLambda0] that is called when the Promise is settled.
     * @return A new [JsPromise] that resolves with the same value or rejection reason as the original Promise.
     */
    fun doFinally(onFinally: JsScope.() -> Unit): JsPromise<JsValue> =
        JsPromise.syntax(
            value = ChainOperation(this, InvocationOperation("finally", onFinally.js)),
            typeBuilder = _typeBuilder_
        )

    companion object
}