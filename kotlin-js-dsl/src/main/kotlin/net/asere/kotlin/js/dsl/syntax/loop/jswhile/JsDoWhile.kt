package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

class JsDoWhileSyntax(value: String) : JsLoopSyntax(value)

/**
 * Creates a JavaScript `do...while` loop.
 * This is a DSL extension function for [JsScriptScope], allowing you to define a loop that
 * executes its block at least once, and then repeatedly as long as the condition is true.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * do {
 * // ... block content ...
 * } while (condition);
 * ```
 * @receiver The [JsScriptScope] where the `do...while` loop is being defined.
 * @param comparable The condition for the `while` part of the loop, which must be an [Operable] expression that evaluates to a boolean in JavaScript.
 * @param block A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the loop body.
 */
@JsDsl
fun JsScriptScope.DoWhile(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
) = +jsDoWhile(
    comparable = comparable,
    block = block
)

/**
 * Creates a JavaScript `do...while` loop syntax.
 * This internal function is used by the [DoWhile] DSL extension.
 *
 * @param comparable The condition for the `while` part of the loop.
 * @param block A lambda to define the JavaScript code inside the loop body.
 * @return A [JsDoWhileSyntax] object representing the `do...while` loop's JavaScript string.
 */
fun jsDoWhile(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsDoWhileSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsDoWhileSyntax(
        """do {
            $scope
        } while ($comparable)""".trimIndent()
    )
}