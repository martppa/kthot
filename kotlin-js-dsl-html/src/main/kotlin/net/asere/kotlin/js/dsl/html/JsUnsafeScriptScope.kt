package net.asere.kotlin.js.dsl.html

import kotlinx.html.FlowContent
import kotlinx.html.Unsafe
import kotlinx.html.script
import kotlinx.html.unsafe
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax

open class JsUnsafeScriptScope(
    private val unsafe: Unsafe
) : JsScriptScope() {
    override fun append(syntax: JsSyntax) = unsafe.raw(syntax.present())
}

fun FlowContent.jsScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    unsafe { block(JsUnsafeScriptScope(this)) }
}