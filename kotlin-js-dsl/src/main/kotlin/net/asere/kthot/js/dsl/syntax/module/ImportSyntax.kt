package net.asere.kthot.js.dsl.syntax.module

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax

fun JsScope.jsImport(module: JsModule) = JsSyntax(module.asImportSyntax())

fun JsScope.Import(module: JsModule) = +jsImport(module)