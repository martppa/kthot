package net.asere.kotlin.js.dsl.html

import kotlinx.html.*
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax

open class JsUnsafeScriptScope(
    private val unsafe: Unsafe
) : JsScope() {

    override fun append(syntax: JsSyntax) {
        unsafe.raw(syntax.present())
    }
}

fun FlowContent.jsScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun HEAD.jsScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun FlowContent.jsScript(source: String) = script {
    type = "text/javascript"
    src = source
}

fun HEAD.jsScript(source: String) = script {
    type = "text/javascript"
    src = source
}