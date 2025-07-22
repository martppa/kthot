package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.value.JsValue

class JsDeclarationSyntax<T : JsValue>(
    innerObject: T,
    syntax: JsSyntax
) : JsResultSyntax<T>(innerObject, syntax)