package net.asere.kthot.js.dsl.syntax.jsreturn

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.JsElement

object Return : JsReturnSyntax()

/**
 * Represents a JavaScript `return` statement with a value.
 * This is a DSL extension function for [JsScope], allowing you to return a value
 * from the current function.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * return element;
 * ```
 * @receiver The [JsScope] where the `return` statement is being used.
 * @param block The [JsElement] returning lambda to be returned from the function.
 */
@JsDsl
fun <T : JsElement> JsScope.Return(block: () -> T): T = block().apply {
    +jsReturn(this)
}

/**
 * Creates a JavaScript `return` statement syntax with a value.
 * This internal function is used by the [Return] DSL extension function.
 *
 * @param element The [JsElement] to be returned.
 * @return A [JsReturnSyntax] object representing the `return` statement's JavaScript string.
 */
fun jsReturn(element: JsElement) = JsReturnSyntax(element)