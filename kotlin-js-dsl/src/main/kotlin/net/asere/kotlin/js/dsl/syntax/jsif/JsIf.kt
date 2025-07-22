package net.asere.kotlin.js.dsl.syntax.jsif

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

open class JsIfSyntax(value: String? = null) : JsSyntax(value)
class JsElseIfSyntax(value: String? = null) : JsIfSyntax(value)
class JsElseSyntax(value: String? = null) : JsSyntax(value)

@JsDsl
fun JsScriptScope.If(comparable: Operable, block: JsSyntaxScope.() -> Unit) = +jsIf(comparable, block)

fun jsIf(comparable: Operable, block: JsSyntaxScope.() -> Unit) : JsIfSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsIfSyntax(
        """if ($comparable) {
            $scope
        }""".trimIndent()
    )
}

@JsDsl
fun JsScriptScope.ElseIf(comparable: Operable, block: JsSyntaxScope.() -> Unit) = +JsIfSyntax().jsElseIf(
    comparable = comparable,
    block = block,
)

fun JsIfSyntax.jsElseIf(comparable: Operable, block: JsSyntaxScope.() -> Unit): JsElseIfSyntax {
    return JsElseIfSyntax(
        "${(this + JsSyntax(
            """ else ${jsIf(comparable, block)}""".trimIndent()
        ))}"
    )
}

@JsDsl
fun JsScriptScope.Else(block: JsSyntaxScope.() -> Unit) = +JsIfSyntax().jsElse(block)

fun JsIfSyntax.jsElse(block: JsSyntaxScope.() -> Unit): JsElseSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return JsElseSyntax(
        "${this + JsSyntax(
            """else {
                    $scope
                }""".trimIndent()
        )}"
    )
}