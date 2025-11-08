package net.asere.kthot.js.dsl.syntax.module

abstract class JsModule {
    abstract val name: String
    abstract val url: String
}

fun JsModule.asImportSyntax(): String = when (this) {
    is JsClassModule -> "import { $name } from '$url'\n"
    is JsFunctionsModule -> "import * as $name from '$url'\n"
    else -> throw IllegalArgumentException("Unsupported module type")
}