package net.asere.kthot.js.dsl.syntax.jstry

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.tag.JsDsl

open class JsFinallySyntax internal constructor(value: JsElement? = null) : JsCatchSyntax(value)

/**
 * Starts a `finally` block in JavaScript.
 * This is a DSL extension function for [JsCatchSyntax] and [JsTrySyntax], allowing you to write
 * `.Finally { ... }` after a `Try` or `Catch` block to complete the `try...catch...finally` statement.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * try {
 * // ... try block content ...
 * } catch (error) {
 * // ... catch block content ...
 * } finally {
 * // ... finally block content ...
 * }
 * ```
 * @receiver The [JsCatchSyntax] (or [JsTrySyntax]) object representing the preceding `try` or `catch` block.
 * @param block A lambda with receiver [JsScope] to define the JavaScript code that
 * will always be executed after the `try` and `catch` blocks complete.
 * @return A [JsFinallySyntax] object, which represents the completed `try...catch...finally` structure.
 */
@JsDsl
fun JsScope.Finally(
    block: JsScope.() -> Unit
) = +JsFinallySyntax().jsFinally(block)

/**
 * Appends a `finally` block to an existing `try` or `catch` statement.
 * This internal function is used by the [Finally] DSL extension.
 *
 * @receiver The [JsTrySyntax] (or [JsCatchSyntax]) object to which the `finally` block is being appended.
 * @param block A lambda with receiver [JsScope] to define the JavaScript code inside the `finally` block.
 * @return A [JsFinallySyntax] object representing the combined conditional structure.
 * @see JsFinally
 */
fun JsTrySyntax.jsFinally(
    block: JsScope.() -> Unit
): JsCatchSyntax = JsFinallySyntax(
    this + JsFinally(
        block = block
    )
)

internal class JsFinally(
    private val block: JsScope.() -> Unit
) : JsCatchSyntax() {

    override val value: String get() {
        val scope = JsSyntaxScope()
        block(scope)
        return """
            finally {
                $scope
            }
        """.trimIndent()
    }
}