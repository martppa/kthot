package net.asere.kotlin.js.dsl.syntax.jsif

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable

fun jsIf(comparable: Operable, block: JsSyntaxScope.() -> Unit) : JsIfSyntaxBuilder {
    val scope = JsSyntaxScope()
    block(scope)
    return JsIfSyntaxBuilder().apply {
        append(
            JsSyntax(
                """if ($comparable) {
                    $scope
                }""".trimIndent()
            )
        )
    }
}