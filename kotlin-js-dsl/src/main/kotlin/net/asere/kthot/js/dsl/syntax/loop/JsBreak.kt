package net.asere.kthot.js.dsl.syntax.loop

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.tag.JsDsl

/**
 * Represents a JavaScript `break` statement.
 * This is a DSL extension property for [JsScope], allowing you to insert a `break` statement
 * directly within a loop or `switch` statement.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * break;
 * ```
 * When executed, it terminates the current loop, `switch`, or `label` statement and transfers
 * control to the statement immediately following the terminated statement.
 * @receiver The [JsScope] where the `break` statement is being used.
 */
@JsDsl
val JsScope.Break get() = +jsBreak()

/**
 * Creates a JavaScript `break` statement syntax.
 * This internal function is used by the [Break] DSL extension property.
 *
 * @return A [JsSyntax] object representing the `break` statement's JavaScript string.
 */
fun jsBreak() = JsSyntax("break")
