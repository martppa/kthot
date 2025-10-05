package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.value.JsValue

class JsDeclarationSyntax<T : JsValue>(
    innerObject: T,
    syntax: JsSyntax
) : JsResultSyntax<T>(innerObject, syntax)