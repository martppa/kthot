package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.*
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScriptScope.While(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
) = jsWhile(
    comparable = comparable,
    block = block
)

fun jsWhile(
    comparable: Operable,
    block: JsSyntaxScope.() -> Unit
): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsLine(
                """while ($comparable) {
                    $scope
                }""".trimIndent()
            )
        )
    }
}