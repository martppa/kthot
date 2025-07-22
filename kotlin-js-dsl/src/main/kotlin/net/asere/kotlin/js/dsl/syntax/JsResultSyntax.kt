package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsResultSyntax<T : JsValue>(
    val innerObject: T,
    syntax: JsSyntax
) : JsSyntax("$syntax")