@file:Suppress("UNCHECKED_CAST")

package net.asere.kthot.js.dsl.syntax.loop.jsfor

import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kthot.js.dsl.syntax.operational.Operation
import net.asere.kthot.js.dsl.syntax.run
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.value.JsValue

class JsForSyntax(value: String) : JsLoopSyntax(value)

/**
 * Creates a traditional JavaScript `for` loop.
 * This is a DSL extension function for [JsScope], allowing you to define a `for` loop with
 * initialization, condition, and iteration expressions.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * for (initialization; condition; iteration) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `for` loop is being defined.
 * @param T The type of the [JsReference] used for the loop variable.
 * @param initialExpression A lambda with receiver [JsSyntaxScope] to define the loop variable's initialization (e.g., `Var("i", 0.js)`). It should return a [JsReference] to the loop variable.
 * @param condition A lambda with receiver [JsSyntaxScope] and the loop variable [T] as an argument, to define the loop's continuation condition (e.g., `it lt 10.js`).
 * @param finalExpression A lambda with receiver [JsSyntaxScope] and the loop variable [T] as an argument, to define the iteration expression (e.g., `it.inc()`).
 * @param block A lambda with receiver [JsSyntaxScope] and the loop variable [T] as an argument, to define the JavaScript code inside the loop body.
 */
@JsDsl
fun <C : JsValue> JsScope.For(
    initialExpression: JsSyntaxScope.() -> C,
    condition: JsSyntaxScope.(C) -> Operation,
    finalExpression: JsSyntaxScope.(C) -> Operation,
    block: JsSyntaxScope.(C) -> Unit,
) = +jsFor(
    initialExpression = initialExpression,
    condition = condition,
    finalExpression = finalExpression,
    block = block
)

/**
 * Creates a JavaScript `for` loop syntax with initialization, condition, and iteration.
 * This internal function is used by the [For] DSL extension for traditional `for` loops.
 *
 * @param T The type of the [JsReference] used for the loop variable.
 * @param initialExpression A lambda to define the loop variable's initialization.
 * @param condition A lambda to define the loop's continuation condition.
 * @param finalExpression A lambda to define the iteration expression.
 * @param block A lambda to define the JavaScript code inside the loop body.
 * @return A [JsForSyntax] object representing the `for` loop's JavaScript string.
 */
fun <T : JsReference<C>, C : JsValue> jsFor(
    initialExpression: JsSyntaxScope.() -> C,
    condition: JsSyntaxScope.(C) -> Operation,
    finalExpression: JsSyntaxScope.(C) -> Operation,
    block: JsSyntaxScope.(C) -> Unit,
): JsForSyntax {
    val initialExpressionScope = JsSyntaxScope()
    val reference = initialExpression(initialExpressionScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsForSyntax(
        """for (${initialExpressionScope.apply { forceSingleLine() }}; ${condition(JsSyntaxScope(), reference)}; ${
            finalExpression(
                JsSyntaxScope(),
                reference
            )
        }) {
                    $blockScope}""".trimIndent()
    )
}

/**
 * Creates a JavaScript `for...in` loop, which iterates over the enumerable properties of an object.
 * This is a DSL extension function for [JsScope].
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * for (variable in object) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `for...in` loop is being defined.
 * @param T The type of the [JsReference] that will hold the property name (key).
 * @param definition A lambda with receiver [JsSyntaxScope] to define the loop variable (e.g., `Var("key")`). It should return a [JsDeclarationSyntax] for the loop variable.
 * @param obj The [JsValue] (object) whose enumerable properties will be iterated over.
 * @param block A lambda with receiver [JsSyntaxScope] and the loop variable [T] as an argument, to define the JavaScript code inside the loop body.
 */
@JsDsl
fun <T : JsReference<C>, C : JsValue> JsScope.For(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsValue,
    block: JsSyntaxScope.(C) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block,
)

/**
 * Creates a JavaScript `for...in` loop syntax.
 * This internal function is used by the [For] DSL extension for `for...in` loops.
 *
 * @param T The type of the [JsReference] that will hold the property name (key).
 * @param definition A lambda to define the loop variable.
 * @param obj The [JsValue] (object) to iterate over.
 * @param block A lambda to define the JavaScript code inside the loop body.
 * @return A [JsForSyntax] object representing the `for...in` loop's JavaScript string.
 */
fun <T : JsReference<C>, C : JsValue> jsFor(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsValue,
    block: JsSyntaxScope.(C) -> Unit,
): JsForSyntax {
    val definitionScope = JsSyntaxScope()
    val reference = definitionScope.run { +definition(definitionScope) }
    val blockScope = JsSyntaxScope()
    block(blockScope, reference as C)
    return JsForSyntax(
        """for (${definitionScope.apply { forceSingleLine() }} in $obj) {
                    $blockScope
                }""".trimIndent()
    )
}

/**
 * Creates a JavaScript `for...of` loop, which iterates over iterable objects (like Arrays, Strings, Maps, Sets).
 * This is a DSL extension function for [JsScope].
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * for (variable of iterable) {
 * // ... block content ...
 * }
 * ```
 * @receiver The [JsScope] where the `for...of` loop is being defined.
 * @param T The type of the [JsReference] that will hold the value of each element.
 * @param definition A lambda with receiver [JsSyntaxScope] to define the loop variable (e.g., `Var("item")`). It should return a [JsDeclarationSyntax] for the loop variable.
 * @param obj The [JsArray] (or any iterable [JsValue]) to iterate over.
 * @param block A lambda with receiver [JsSyntaxScope] and the loop variable [T] as an argument, to define the JavaScript code inside the loop body.
 */
@JsDsl
fun <T : JsReference<C>, C : JsValue> JsScope.For(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsArray<*>,
    block: JsSyntaxScope.(C) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block
)

/**
 * Creates a JavaScript `for...of` loop syntax.
 * This internal function is used by the [For] DSL extension for `for...of` loops.
 *
 * @param T The type of the [JsReference] that will hold the value of each element.
 * @param definition A lambda to define the loop variable.
 * @param obj The [JsArray] (or any iterable [JsValue]) to iterate over.
 * @param block A lambda to define the JavaScript code inside the loop body.
 * @return A [JsForSyntax] object representing the `for...of` loop's JavaScript string.
 */
fun <T : JsReference<C>, C : JsValue> jsFor(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsArray<*>,
    block: JsSyntaxScope.(C) -> Unit,
): JsForSyntax {
    val definitionScope = JsSyntaxScope()
    val reference = definitionScope.run { +definition(definitionScope) }
    val blockScope = JsSyntaxScope()
    block(blockScope, reference as C)
    return JsForSyntax(
        """for (${definitionScope.apply { forceSingleLine() }} of $obj) {
                    $blockScope
                }""".trimIndent()
    )
}

/**
 * Iterates over the elements of a [JsArray] using its `forEach` method.
 * This is a DSL extension function for [JsScope], providing a convenient way to
 * perform an action for each element in a JavaScript array.
 *
 * In JavaScript, this corresponds to:
 * ```javascript
 * collection.forEach(lambda);
 * ```
 * @receiver The [JsScope] where the `forEach` call is being defined.
 * @param T The type of elements in the [JsArray].
 * @param collection The [JsArray] to iterate over.
 * @param lambda A [JsLambda1] that will be executed for each element in the collection.
 * The lambda typically receives the current element as its first argument.
 */
@JsDsl
fun <T : JsValue> JsScope.For(
    collection: JsArray<T>,
    lambda: JsLambda1<T>,
) = +collection.forEach(lambda)