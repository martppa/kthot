package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

class JsDoWhileSyntax(value: String) : JsLoopSyntax(value)

@JsDsl
fun JsScriptScope.DoWhile(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
) = +jsDoWhile(
    comparable = comparable,
    block = block
)

fun jsDoWhile(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsDoWhileSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsDoWhileSyntax(
        """do {
            $scope
        } while ($comparable)""".trimIndent()
    )
}