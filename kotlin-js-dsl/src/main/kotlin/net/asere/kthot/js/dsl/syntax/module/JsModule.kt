package net.asere.kthot.js.dsl.syntax.module

interface JsModule {
    val name: String
    val url: String
    val items: List<JsModuleItem>
}

fun JsModule.asImportSyntax(): String = "import { ${items.joinToString { it.name }} } from '$url'\n"