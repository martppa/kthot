package net.asere.kotlin.js.dsl.syntax.loop

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl

/**
 * Represents a JavaScript `break` statement.
 * This is a DSL extension property for [JsScriptScope], allowing you to insert a `break` statement
 * directly within a loop or `switch` statement.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * break;
 * ```
 * When executed, it terminates the current loop, `switch`, or `label` statement and transfers
 * control to the statement immediately following the terminated statement.
 * @receiver The [JsScriptScope] where the `break` statement is being used.
 */
@JsDsl
val JsScriptScope.Break get() = +jsBreak()

/**
 * Creates a JavaScript `break` statement syntax.
 * This internal function is used by the [Break] DSL extension property.
 *
 * @return A [JsSyntax] object representing the `break` statement's JavaScript string.
 */
fun jsBreak() = JsSyntax("break")
