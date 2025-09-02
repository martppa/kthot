package net.asere.kotlin.js.dsl.syntax.jstry

import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.tag.JsDsl

open class JsTrySyntax internal constructor(value: JsElement? = null) : JsSyntax("$value")

internal class JsTry(
    private val block: JsScope.() -> Unit
) : JsTrySyntax() {

    override val value: String get() {
        val scope = JsSyntaxScope()
        block(scope)
        return """
            try {
                $scope
            }
        """.trimIndent()
    }
}

/**
 * Creates a JavaScript `try` statement syntax.
 * This internal function is typically used by a DSL extension function (e.g., `Try { ... }`)
 * to initiate a `try` block, which can then be chained with `catch` and `finally` blocks.
 *
 * @param block A lambda with receiver [JsScope] to define the JavaScript code
 * that will be attempted within the `try` block.
 * @return A [JsTrySyntax] object representing the `try` block's JavaScript string.
 * @see JsTry
 */
fun jsTry(
    block: JsScope.() -> Unit
): JsTrySyntax = JsTry(
    block = block,
)

/**
 * Starts a `try` block in JavaScript.
 * This is a DSL extension function for [JsScope], allowing you to write `Try { ... }`
 * directly within a script scope. The function returns a [JsTrySyntax] object, which can
 * then be used to fluently chain a `.Catch` or `.Finally` block.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * try {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `try` block is being defined.
 * @param block A lambda with receiver [JsScope] to define the JavaScript code that
 * will be attempted within the `try` block.
 * @return A [JsTrySyntax] object representing the `try` block, enabling method chaining.
 */
@JsDsl
fun JsScope.Try(
    block: JsScope.() -> Unit
) = +jsTry(block)