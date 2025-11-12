package net.asere.kthot.js.dsl.syntax.module

import net.asere.kthot.js.dsl.syntax.JsLine
import net.asere.kthot.js.dsl.syntax.JsSyntax

data class JsImport(
    val importedItems: List<JsModuleItem>,
    val module: JsModule,
)

fun JsImport.toSyntax(): JsSyntax = JsLine("import { ${
    run { importedItems.takeIf { !it.isEmpty() } ?: module.items }.joinToString { it.name }
} } from '${module.url}'")