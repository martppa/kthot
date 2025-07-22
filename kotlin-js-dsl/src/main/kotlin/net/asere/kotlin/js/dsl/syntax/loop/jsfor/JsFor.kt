package net.asere.kotlin.js.dsl.syntax.loop.jsfor

import net.asere.kotlin.js.dsl.callable.JsLambda1
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.syntax.operation.Operation
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.value.JsValue

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
): JsSyntaxBuilder<Unit> {
    val assignmentScope = JsSyntaxScope()
    val reference = assignment(assignmentScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsLine(
                """for (${assignmentScope.apply { forceSingleLine() }}; ${comparison(JsSyntaxScope(), reference)}; ${
                    operation(
                        JsSyntaxScope(),
                        reference
                    )
                }) {
                    $blockScope}""".trimIndent()
            )
        )
    }
}

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> T,
    obj: JsValue,
    block: JsSyntaxScope.(T) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block,
)

fun <T : JsReference<*>> jsFor(
    definition: JsSyntaxScope.() -> T,
    obj: JsValue,
    block: JsSyntaxScope.(T) -> Unit,
): JsSyntaxBuilder<Unit> {
    val definitionScope = JsSyntaxScope()
    val reference = definition(definitionScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsLine(
                """for (${definitionScope.apply { forceSingleLine() }} in $obj) {
                    $blockScope
                }""".trimIndent()
            )
        )
    }
}

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> T,
    obj: JsCollection<*>,
    block: JsSyntaxScope.(T) -> Unit,
) = +jsFor(
    definition = definition,
    obj = obj,
    block = block
)

fun <T : JsReference<*>> jsFor(
    definition: JsSyntaxScope.() -> T,
    obj: JsCollection<*>,
    block: JsSyntaxScope.(T) -> Unit,
): JsSyntaxBuilder<Unit> {
    val definitionScope = JsSyntaxScope()
    val reference = definition(definitionScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsLine(
                """for (${definitionScope.apply { forceSingleLine() }} of $obj) {
                    $blockScope
                }""".trimIndent()
            )
        )
    }
}

@JsDsl
fun <T : JsValue> JsScriptScope.For(
    collection: JsCollection<T>,
    lambda: JsLambda1<T>,
) = +collection.forEach(lambda)