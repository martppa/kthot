package net.asere.kotlin.js.dsl.syntax.jsif

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

open class JsIfSyntax(value: String? = null) : JsSyntax(value)
class JsElseIfSyntax(value: String? = null) : JsIfSyntax(value)
class JsElseSyntax(value: String? = null) : JsSyntax(value)

/**
 * Starts an `if` block in JavaScript.
 * This is a DSL extension function for [JsScriptScope], allowing you to write `If (condition) { ... }` directly within a script scope.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * if (comparable) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScriptScope] where the `if` block is being defined.
 * @param comparable The condition for the `if` statement, which must be an [Operable] expression that evaluates to a boolean in JavaScript.
 * @param block A lambda with receiver [JsSyntaxScope] to define the JavaScript code that will be executed if the condition is true.
 */
@JsDsl
fun JsScriptScope.If(comparable: Operable, block: JsSyntaxScope.() -> Unit) = +jsIf(comparable, block)

/**
 * Creates a JavaScript `if` statement syntax.
 * This internal function is used by the [If] DSL extension.
 *
 * @param comparable The condition for the `if` statement.
 * @param block A lambda to define the JavaScript code inside the `if` block.
 * @return A [JsIfSyntax] object representing the `if` block's JavaScript string.
 */
fun jsIf(comparable: Operable, block: JsSyntaxScope.() -> Unit) : JsIfSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsIfSyntax(
        """if ($comparable) {
            $scope
        }""".trimIndent()
    )
}

/**
 * Adds an `else if` block to a preceding `if` or `else if` statement.
 * This is a DSL extension function for [JsScriptScope], allowing you to write `ElseIf (condition) { ... }`
 * to chain conditional blocks. Note that for proper chaining, this should typically follow an `If` or `ElseIf` call
 * in a fluent API style, though the current implementation allows it directly in the scope.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * ... else if (comparable) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScriptScope] where the `else if` block is being defined.
 * @param comparable The condition for the `else if` statement.
 * @param block A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the `else if` block.
 */
@JsDsl
fun JsScriptScope.ElseIf(comparable: Operable, block: JsSyntaxScope.() -> Unit) = +JsIfSyntax().jsElseIf(
    comparable = comparable,
    block = block,
)

/**
 * Appends an `else if` block to an existing [JsIfSyntax] (or [JsElseIfSyntax]).
 * This internal function is used by the [ElseIf] DSL extension.
 *
 * @param comparable The condition for the `else if` statement.
 * @param block A lambda to define the JavaScript code inside the `else if` block.
 * @return A [JsElseIfSyntax] object representing the combined conditional structure.
 */
fun JsIfSyntax.jsElseIf(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsElseIfSyntax {
    return JsElseIfSyntax(
        "${(this + JsSyntax(
            """ else ${jsIf(comparable, block)}""".trimIndent()
        ))}"
    )
}

/**
 * Adds an `else` block to a preceding `if` or `else if` statement.
 * This is a DSL extension function for [JsScriptScope], allowing you to write `Else { ... }`
 * to provide a fallback block. Note that for proper chaining, this should typically follow an `If` or `ElseIf` call
 * in a fluent API style, though the current implementation allows it directly in the scope.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * ... else {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScriptScope] where the `else` block is being defined.
 * @param block A lambda with receiver [JsSyntaxScope] to define the JavaScript code inside the `else` block.
 */
@JsDsl
fun JsScriptScope.Else(block: JsSyntaxScope.() -> Unit) = +JsIfSyntax().jsElse(block)

/**
 * Appends an `else` block to an existing [JsIfSyntax] (or [JsElseIfSyntax]).
 * This internal function is used by the [Else] DSL extension.
 *
 * @param block A lambda to define the JavaScript code inside the `else` block.
 * @return A [JsElseSyntax] object representing the combined conditional structure.
 */
fun JsIfSyntax.jsElse(block: JsSyntaxScope.() -> Unit): JsElseSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsElseSyntax(
        "${this + JsSyntax(
            """else {
                    $scope
                }""".trimIndent()
        )}"
    )
}