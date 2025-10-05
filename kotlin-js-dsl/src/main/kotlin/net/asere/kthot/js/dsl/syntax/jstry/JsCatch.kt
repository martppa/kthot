package net.asere.kthot.js.dsl.syntax.jstry

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.error.JsErrorRef

open class JsCatchSyntax internal constructor(value: JsElement? = null) : JsTrySyntax(value)

/**
 * Appends a `catch` block to a preceding `try` statement.
 * This is an extension function for [JsTrySyntax], allowing you to chain a `catch` block
 * directly after a `try` block in a fluent API style.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * try {
 * // ... try block content ...
 * } catch (errorVariableName) {
 * // ... catch block content ...
 * }
 * ```
 * @receiver The [JsTrySyntax] object to which the `catch` block is being appended.
 * @param error A [JsDefinition] that provides the reference ([JsError]) for the error variable
 * to be used in the `catch` block (e.g., `error`).
 * @param block A lambda with receiver [JsScope] and a [JsError] parameter,
 * to define the JavaScript code that will be executed if an error occurs.
 * @return A [JsCatchSyntax] object representing the combined `try...catch` structure.
 * @see JsCatch
 */
fun JsTrySyntax.jsCatch(
    error: JsDefinition<JsErrorRef, JsError>,
    block: JsScope.(JsError) -> Unit
): JsCatchSyntax = JsCatchSyntax(
    this + JsCatch(
        error = error.reference,
        block = block
    )
)

/**
 * Adds a `catch` block to a preceding `try` statement.
 * This is a DSL extension function for [JsTrySyntax], allowing you to write
 * `... .Catch(...) { ... }` directly after a `Try` call to chain the blocks.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * try {
 * //...
 * } catch (error) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsTrySyntax] object representing the preceding `try` block.
 * @param error The [JsDefinition] that provides the reference for the error variable.
 * @param block A lambda with receiver [JsScope] and a [JsError] parameter,
 * to define the JavaScript code that will be executed if an error occurs.
 * @return A [JsCatchSyntax] object representing the combined `try...catch` structure.
 */
@JsDsl
fun JsScope.Catch(
    error: JsDefinition<JsErrorRef, JsError>,
    block: JsScope.(JsError) -> Unit
) = +JsCatchSyntax().jsCatch(error, block)

internal class JsCatch(
    private val error: JsError,
    private val block: JsScope.(JsError) -> Unit
) : JsCatchSyntax() {

    override val value: String get() {
        val scope = JsSyntaxScope()
        block(scope, error)
        return """
            catch($error) {
                $scope
            }
        """.trimIndent()
    }
}