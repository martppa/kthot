package net.asere.kotlin.js.dsl.types.type

import net.asere.kotlin.js.dsl.syntax.instantiation.Instantiable
import net.asere.kotlin.js.dsl.syntax.value.JsPromiseSyntax
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

/**
 * Represents a JavaScript `Promise` object.
 * This is a generic interface as Promises can resolve to various types.
 */
interface JsPromise<T : JsValue> : JsObject, Instantiable {
    fun then(onFulfilled: JsLambda1<T>): JsPromise<T> = JsPromiseSyntax("${this}.then($onFulfilled)")
    fun then(onFulfilled: JsLambda1<T>, onRejected: JsLambda1<JsValue>): JsPromise<JsValue> =
        JsPromiseSyntax("${this}.then($onFulfilled, $onRejected)")

    fun `catch`(onRejected: JsLambda1<JsValue>): JsPromise<JsValue> = JsPromiseSyntax("${this}.catch($onRejected)")
    fun `finally`(onFinally: JsLambda): JsPromise<JsValue> = JsPromiseSyntax("${this}.finally($onFinally)")

    companion object
}