package net.asere.kotlin.js.dsl.syntax.loop.jsfor

import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsLine
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
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
) {
    val assignmentScope = JsSyntaxScope()
    val reference = assignment(assignmentScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
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

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> T,
    obj: JsValue,
    block: JsSyntaxScope.(T) -> Unit,
) {
    val definitionScope = JsSyntaxScope()
    val reference = definition(definitionScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    append(
        JsLine(
            """for (${definitionScope.apply { forceSingleLine() }} in $obj) {
                    $blockScope
                }""".trimIndent()
        )
    )
}

@JsDsl
fun <T : JsReference<*>> JsScriptScope.For(
    definition: JsSyntaxScope.() -> T,
    obj: JsCollection<*>,
    block: JsSyntaxScope.(T) -> Unit,
) {
    val definitionScope = JsSyntaxScope()
    val reference = definition(definitionScope)
    val blockScope = JsSyntaxScope()
    block(blockScope, reference)
    append(
        JsLine(
            """for (${definitionScope.apply { forceSingleLine() }} of $obj) {
                    $blockScope
                }""".trimIndent()
        )
    )
}