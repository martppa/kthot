package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement

abstract class JsResultSyntax<T : JsElement>(
    val innerObject: T,
    syntax: JsSyntax
) : JsSyntax("$syntax")