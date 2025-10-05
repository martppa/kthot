package net.asere.kthot.js.dsl.declaration

import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.definition.JsDefinition
import net.asere.kthot.js.dsl.type.value.JsValue

class JsConstantDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("const $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScope.Const(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(DeclarationType.CONST)