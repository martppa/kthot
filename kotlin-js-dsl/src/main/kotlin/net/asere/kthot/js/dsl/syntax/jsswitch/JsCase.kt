package net.asere.kthot.js.dsl.syntax.jsswitch

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.Operable
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.toLine

/**
 * Defines a `case` block within a `switch` statement.
 * This is a DSL extension function for [JsSwitchScope], allowing you to write
 * `Case(value) { ... }` inside a `Switch` block.
 *
 * This function also supports multiple `case` statements for the same code block,
 * which is useful for fall-through logic.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * case comparable:
 * // ... block content ...
 * ```
 * @receiver The [JsSwitchScope] where the `case` block is being defined.
 * @param operables The expressions for the `case` statement. Multiple expressions can
 * be provided to handle several cases with the same code.
 * @param block A lambda with receiver [JsScope] to define the JavaScript code that
 * will be executed if the `switch` expression matches the `case` value.
 */
@JsDsl
fun JsSwitchScope.Case(
    vararg operables: Operable,
    block: JsScope.() -> Unit,
) = +jsCase(operables = operables, block = block)

/**
 * Creates a JavaScript `case` statement syntax.
 * This function is used by the DSL extension function [Case] to define
 * a `case` block within a `switch` statement.
 *
 * @receiver The [JsSwitchScope] where the `case` block is being defined.
 * @param operables The expressions to be evaluated in the `case` statement.
 * Multiple expressions can be provided to group several cases to a single block of code.
 * @param block A lambda with receiver [JsScope] to define the JavaScript code
 * to be executed if the `switch` expression matches one of the `case` values.
 * @return A [JsSyntax] object representing the `case` block's JavaScript string.
 * @see JsCase
 */
fun JsSwitchScope.jsCase(
    vararg operables: Operable,
    block: JsScope.() -> Unit,
): JsSyntax = JsCase(operables = operables, block = block)

internal class JsCase(
    private vararg val operables: Operable,
    private val block: JsScope.() -> Unit,
) : JsSyntax() {

    override val value: String get() {
        val scope = JsSyntaxScope()
        block(scope)
        val stringBuilder = StringBuilder()
        operables.forEach { stringBuilder.append(JsSyntax("case $it:").toLine()) }
        return """
            $stringBuilder
            $scope
        """.trimIndent()
    }
}