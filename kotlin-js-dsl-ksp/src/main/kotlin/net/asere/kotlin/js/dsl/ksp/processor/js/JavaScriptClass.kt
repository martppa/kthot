package net.asere.kotlin.js.dsl.ksp.processor.js

import net.asere.kotlin.js.dsl.ksp.js.JsConstructorScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.toSyntax

abstract class JavaScriptClass {
    var constructorBody: JsSyntax? = null
        private set

    @JsDsl
    protected fun Constructor(block: JsConstructorScope.() -> Unit) {
        val scope = JsConstructorScope()
        block(scope)
        constructorBody = scope.toSyntax()
    }
}