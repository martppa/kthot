package net.asere.kthot.js.dsl.declaration

import net.asere.kthot.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

class JsLetDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("let $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScope.Let(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(DeclarationType.LET)