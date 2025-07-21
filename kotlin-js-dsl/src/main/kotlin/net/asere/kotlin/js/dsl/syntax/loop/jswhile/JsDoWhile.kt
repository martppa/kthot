package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.JsLine
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScriptScope.DoWhile(comparable: Operable, block: JsSyntaxScope.() -> Unit) {
    val scope = JsSyntaxScope()
    block(scope)
    append(
        JsLine(
            """do {
                    $scope
                } while ($comparable)""".trimIndent()
        )
    )
}