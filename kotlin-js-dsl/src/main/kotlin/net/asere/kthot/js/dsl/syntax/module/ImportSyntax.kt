package net.asere.kthot.js.dsl.syntax.module

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax

fun JsScope.jsImport(from: JsModule, vararg items: JsModuleItem): JsSyntax =
    JsImport(items.toList(), from).toSyntax()

fun JsScope.Import(from: JsModule, vararg items: JsModuleItem) = +jsImport(from, *items)