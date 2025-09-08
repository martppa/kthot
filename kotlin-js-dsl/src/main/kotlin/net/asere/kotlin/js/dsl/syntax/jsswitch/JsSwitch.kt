package net.asere.kotlin.js.dsl.syntax.jsswitch

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

/**
 * Starts a `switch` block in JavaScript.
 * This is a DSL extension function for [JsScope], allowing you to write
 * `Switch(expression) { ... }` directly within a script scope.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * switch (comparable) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `switch` block is being defined.
 * @param operable The expression for the `switch` statement, which must be an [Operable]
 * expression that will be compared against `case` values.
 * @param block A lambda with receiver [JsSwitchScope] to define the `case` and `default`
 * statements inside the `switch` block.
 */
@JsDsl
fun JsScope.Switch(
    operable: Operable,
    block: JsSwitchScope.() -> Unit
) = +jsSwitch(
    operable = operable,
    block = block
)

/**
 * Creates a JavaScript `switch` statement syntax.
 * This function is used by the DSL extension function [Switch] to begin a `switch`
 * block, which can then contain `case` and `default` statements.
 *
 * @param operable The expression to be evaluated in the `switch` statement.
 * @param block A lambda with receiver [JsSwitchScope] to define the `case` and `default`
 * blocks within the `switch` statement.
 * @return A [JsSyntax] object representing the `switch` block's JavaScript string.
 * @see JsSwitch
 */
fun jsSwitch(
    operable: Operable,
    block: JsSwitchScope.() -> Unit
): JsSyntax = JsSwitch(
    operable = operable,
    block = block,
)

internal class JsSwitch(
    private val operable: Operable,
    private val block: JsSwitchScope.() -> Unit
) : JsSyntax() {

    override val value: String get() {
        val scope = JsSwitchScope()
        block(scope)
        return """
            switch($operable) {
                $scope
            }
        """.trimIndent()
    }
}