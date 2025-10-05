package net.asere.kthot.js.dsl.html

import kotlinx.html.*
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax

open class JsUnsafeScriptScope(
    private val unsafe: Unsafe
) : JsScope() {

    override fun append(syntax: JsSyntax) {
        unsafe.raw(syntax.present())
    }
}

fun FlowContent.jslScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun HEAD.jslScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun FlowContent.jslScript(source: String) = script {
    type = "text/javascript"
    src = source
}

fun HEAD.jslScript(source: String) = script {
    type = "text/javascript"
    src = source
}