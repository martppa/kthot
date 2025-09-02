package net.asere.kotlin.js.dsl.syntax.loop

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl

/**
 * Represents a JavaScript `continue` statement.
 * This is a DSL extension property for [JsScope], allowing you to insert a `continue` statement
 * directly within a loop.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * continue;
 * ```
 * When executed, it terminates execution of the statements in the current iteration of the current
 * loop, and continues execution of the loop with the next iteration.
 * @receiver The [JsScope] where the `continue` statement is being used.
 */
@JsDsl
val JsScope.Continue get() = +jsContinue()

/**
 * Creates a JavaScript `continue` statement syntax.
 * This internal function is used by the [Continue] DSL extension property.
 *
 * @return A [JsSyntax] object representing the `continue` statement's JavaScript string.
 */
fun jsContinue() = JsSyntax("continue")