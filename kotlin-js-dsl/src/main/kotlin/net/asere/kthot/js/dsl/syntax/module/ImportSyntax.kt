package net.asere.kthot.js.dsl.syntax.module

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax

fun JsScope.jsImport(vararg items: JsModuleItem, from: JsModule) = if (items.isEmpty()) {
    JsSyntax(from.asImportSyntax())
} else {
    JsSyntax("import { ${items.joinToString { it.name }} } from '${from.url}'\n")
}

fun JsScope.Import(vararg items: JsModuleItem, from: JsModule) = +jsImport(items = items, from = from)