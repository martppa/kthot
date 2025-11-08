package net.asere.kthot.js.dsl.ksp.processor.js

import net.asere.kthot.js.dsl.syntax.module.JsModule

abstract class JavaScriptModule {
    private val mutableRequirements: MutableSet<JsModule> =  mutableSetOf()
    val requirements get() = mutableRequirements.toList()

    protected fun importModule(module: JsModule) {
        mutableRequirements.add(module)
    }
}