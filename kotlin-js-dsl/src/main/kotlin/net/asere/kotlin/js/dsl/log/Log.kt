package net.asere.kotlin.js.dsl.log

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl

/**
 * Logs a [JsElement] to the browser's console.
 * This is a DSL extension function for [JsScriptScope].
 *
 * In JavaScript, this corresponds to `console.log(element)`.
 * @receiver The [JsScriptScope] where the log operation is performed.
 * @param element The [JsElement] object to log.
 */
@JsDsl
fun JsScriptScope.Log(element: JsElement) = +Console.log(element)

/**
 * Logs a [String] to the browser's console.
 * This is a DSL extension function for [JsScriptScope].
 *
 * In JavaScript, this corresponds to `console.log(text)`.
 * @receiver The [JsScriptScope] where the log operation is performed.
 * @param text The [String] to log.
 */
@JsDsl
fun JsScriptScope.Log(text: String) = +Console.log(text)