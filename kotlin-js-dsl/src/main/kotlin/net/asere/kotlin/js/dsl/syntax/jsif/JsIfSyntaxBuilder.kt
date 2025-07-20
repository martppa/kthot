package net.asere.kotlin.js.dsl.syntax.jsif

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable

class JsIfSyntaxBuilder : JsSyntaxBuilder<Unit>(Unit)

fun JsIfSyntaxBuilder.jsElseIf(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsIfSyntaxBuilder {
    return apply {
        append(
            JsSyntax(
                """else ${jsIf(comparable, block)}
                """.trimIndent()
            )
        )
    }
}

fun JsIfSyntaxBuilder.jsElse(block: JsSyntaxScope.() -> Unit): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return apply {
        append(
            JsSyntax(
                """else {
                    $scope
                }""".trimIndent()
            )
        )
    }
}