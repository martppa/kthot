package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <reified T : JsValue> genericSyntax(block: JsScope.() -> T): T {
    val scope = JsSyntaxScope()
    scope.block()
    return provide(scope)
}