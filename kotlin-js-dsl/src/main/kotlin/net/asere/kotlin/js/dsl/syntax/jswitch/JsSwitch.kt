package net.asere.kotlin.js.dsl.syntax.jswitch

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operational.Operable
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScriptScope.Switch(
    operable: Operable,
    block: JsSwitchScope.() -> Unit
) = +jsSwitch(
    operable = operable,
    block = block
)

fun jsSwitch(
    operable: Operable,
    block: JsSwitchScope.() -> Unit
): JsSyntax = JsSwitch(
    operable = operable,
    block = block,
)

internal class JsSwitch(
    private val operable: Operable,
    private val block: JsSwitchScope.() -> Unit
) : JsSyntax() {

    override val value: String get() {
        val scope = JsSwitchScope()
        block(scope)
        return """
            switch($operable) {
                $scope
            }
        """.trimIndent()
    }
}