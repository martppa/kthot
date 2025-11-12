package net.asere.kthot.js.dsl.ksp.processor.js

import net.asere.kthot.js.dsl.syntax.module.JsModule
import net.asere.kthot.js.dsl.syntax.module.JsModuleItem
import net.asere.kthot.js.dsl.syntax.module.JsImport

abstract class JavaScriptModule {
    private val mutableRequirements: MutableSet<JsImport> =  mutableSetOf()
    val requirements get() = mutableRequirements.toList()

    protected fun importModule(from: JsModule, vararg items: JsModuleItem) {
        mutableRequirements.add(JsImport(items.toList(), from))
    }
}