package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.syntax.loop.JsLoopSyntax
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

class JsWhileSyntax(value: String) : JsLoopSyntax(value)

@JsDsl
fun JsScriptScope.While(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
) = +jsWhile(
    comparable = comparable,
    block = block
)

fun jsWhile(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
): JsWhileSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsWhileSyntax(
        """while ($comparable) {
            $scope
        }""".trimIndent()
    )
}