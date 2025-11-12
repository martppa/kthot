package net.asere.kthot.js.dsl.syntax.module

interface JsModule {
    val name: String
    val url: String
    val items: List<JsModuleItem>
}