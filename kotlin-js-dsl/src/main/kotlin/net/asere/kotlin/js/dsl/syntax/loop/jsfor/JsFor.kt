package net.asere.kotlin.js.dsl.syntax.loop.jsfor

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kotlin.js.dsl.syntax.operation.Operation
import net.asere.kotlin.js.dsl.syntax.run
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.type.JsCollection
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsForSyntax(value: String) : JsLoopSyntax(value)

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    assignment: JsSyntaxScope.() -> T,
    comparison: JsSyntaxScope.(T) -> Operation,
    operation: JsSyntaxScope.(T) -> Operation,
    block: JsSyntaxScope.(T) -> Unit,
) = +jsFor(
    assignment = assignment,
    comparison = comparison,
    operation = operation,
    block = block
)

fun <T : JsReference<*>> jsFor(
    assignment: JsSyntaxScope.() -> T,
    comparison: JsSyntaxScope.(T) -> Operation,
    operation: JsSyntaxScope.(T) -> Operation,
    block: JsSyntaxScope.(T) -> Unit,
): JsForSyntax {
    val assignmentScope = JsSyntaxScope()
    val reference = assignment(assignmentScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsForSyntax(
        """for (${assignmentScope.apply { forceSingleLine() }}; ${comparison(JsSyntaxScope(), reference)}; ${
            operation(
                JsSyntaxScope(),
                reference
            )
        }) {
                    $blockScope}""".trimIndent()
    )
}

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsValue,
    block: JsSyntaxScope.(T) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block,
)

fun <T : JsReference<*>> jsFor(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsValue,
    block: JsSyntaxScope.(T) -> Unit,
): JsForSyntax {
    val definitionScope = JsSyntaxScope()
    val reference = definitionScope.run { +definition(definitionScope) }
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsForSyntax(
        """for (${definitionScope.apply { forceSingleLine() }} in $obj) {
                    $blockScope
                }""".trimIndent()
    )
}

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsCollection<*>,
    block: JsSyntaxScope.(T) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block
)

fun <T : JsReference<*>> jsFor(
    definition: JsSyntaxScope.() -> JsDeclarationSyntax<T>,
    obj: JsCollection<*>,
    block: JsSyntaxScope.(T) -> Unit,
): JsForSyntax {
    val definitionScope = JsSyntaxScope()
    val reference = definitionScope.run { +definition(definitionScope) }
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsForSyntax(
        """for (${definitionScope.apply { forceSingleLine() }} of $obj) {
                    $blockScope
                }""".trimIndent()
    )
}

@JsDsl
fun <T : JsValue> JsScriptScope.For(
    collection: JsCollection<T>,
    lambda: JsLambda1<T>,
) = +collection.forEach(lambda)