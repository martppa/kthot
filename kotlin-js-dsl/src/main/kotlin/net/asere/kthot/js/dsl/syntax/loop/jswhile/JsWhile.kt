package net.asere.kthot.js.dsl.syntax.loop.jswhile

import net.asere.kthot.js.dsl.syntax.*
import net.asere.kthot.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.tag.JsDsl

class JsWhileSyntax(value: String) : JsLoopSyntax(value)

/**
 * Creates a JavaScript `while` loop.
 * This is a DSL extension function for [JsScope], allowing you to define a loop that
 * repeatedly executes its block as long as the condition is true.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * while (condition) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `while` loop is being defined.
 * @param comparable The condition for the `while` loop, which must be an [Operable] expression that evaluates to a boolean in JavaScript.
 * @param block A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the loop body.
 */
@JsDsl
fun JsScope.While(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
) = +jsWhile(
    comparable = comparable,
    block = block
)

/**
 * Creates a JavaScript `while` loop syntax.
 * This internal function is used by the [While] DSL extension.
 *
 * @param comparable The condition for the `while` loop.
 * @param block A lambda to define the JavaScript code inside the loop body.
 * @return A [JsWhileSyntax] object representing the `while` loop's JavaScript string.
 */
fun jsWhile(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
): JsWhileSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsWhileSyntax(
        """while ($comparable) {
            $scope
        }""".trimIndent()
    )
}