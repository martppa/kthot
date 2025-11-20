package net.asere.kthot.js.dsl.ksp.processor.js

import net.asere.kthot.js.dsl.ksp.js.JsConstructorScope
import net.asere.kthot.js.dsl.syntax.JsAssignationSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.syntax.instantiation.Instantiable
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.toLine
import net.asere.kthot.js.dsl.type.toSyntax
import net.asere.kthot.js.dsl.type.value.JsValue

abstract class JavaScriptClass : JavaScriptModule(), Instantiable {
    var constructorBody: JsSyntax? = null
        private set

    @JsDsl
    protected fun Constructor(block: JsConstructorScope.() -> Unit) {
        val scope = JsConstructorScope()
        block(scope)
        constructorBody = scope.toSyntax()
    }
}