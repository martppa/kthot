package net.asere.kthot.js.dsl.html

import kotlinx.html.*
import net.asere.kthot.js.dsl.syntax.module.JsModule
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
    type = "module"
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun HEAD.jslScript(block: JsUnsafeScriptScope.() -> Unit) = script {
    type = "module"
    unsafe { block(JsUnsafeScriptScope(this)) }
}

fun FlowContent.jslScript(module: JsModule) = script {
    type = "module"
    src = module.url
}

fun HEAD.jslScript(module: JsModule) = script {
    type = "module"
    src = module.url
}