package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.toSyntax

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}