package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsVarDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("var $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScope.Var(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(DeclarationType.Var)