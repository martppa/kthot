package net.asere.kthot.js.dsl.log

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.tag.JsDsl

/**
 * Logs a [JsElement] to the browser's console.
 * This is a DSL extension function for [JsScope].
 *
 * In JavaScript, this corresponds to `console.log(element)`.
 * @receiver The [JsScope] where the log operation is performed.
 * @param element The [JsElement] object to log.
 */
@JsDsl
fun JsScope.Log(element: JsElement) = +Console.log(element)

/**
 * Logs a [String] to the browser's console.
 * This is a DSL extension function for [JsScope].
 *
 * In JavaScript, this corresponds to `console.log(text)`.
 * @receiver The [JsScope] where the log operation is performed.
 * @param text The [String] to log.
 */
@JsDsl
fun JsScope.Log(text: String) = +Console.log(text)