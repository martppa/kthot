package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable

fun jsDoWhile(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsSyntax(
                """do {
                    $scope
                } while ($comparable)""".trimIndent()
            )
        )
    }
}