package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsLetDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("let $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScope.Let(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(DeclarationType.LET)