package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

abstract class JsResultSyntax<T : JsElement>(
    val innerObject: T,
    syntax: JsSyntax
) : JsSyntax("$syntax")