package net.asere.kotlin.js.dsl.syntax.jswitch

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.toLine

@JsDsl
fun JsSwitchScope.Case(
    vararg operables: Operable,
    block: JsScriptScope.() -> Unit,
) = +jsCase(operables = operables, block = block)

fun JsSwitchScope.jsCase(
    vararg operables: Operable,
    block: JsScriptScope.() -> Unit,
): JsSyntax = JsCase(operables = operables, block = block)

internal class JsCase(
    private vararg val operables: Operable,
    private val block: JsScriptScope.() -> Unit,
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