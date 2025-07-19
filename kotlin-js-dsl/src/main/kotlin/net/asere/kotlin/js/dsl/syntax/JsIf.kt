package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.syntax.comparison.Comparable

class JsIfSyntaxBuilder : JsSyntaxBuilder<Unit>(Unit)

fun jsIf(comparable: Comparable, block: JsSyntaxScope.() -> Unit) : JsIfSyntaxBuilder  {
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

fun JsIfSyntaxBuilder.jsElseIf(comparable: Comparable, block: JsSyntaxScope.() -> Unit): JsIfSyntaxBuilder {
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