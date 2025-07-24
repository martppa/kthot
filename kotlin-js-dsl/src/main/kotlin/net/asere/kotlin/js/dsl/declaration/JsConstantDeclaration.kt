package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsConstantDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("const $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScriptScope.Const(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(Const)