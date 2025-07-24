package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsDeclarationSyntax
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsVarDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("var $jsObject")

@JsDsl
fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> JsScriptScope.Var(block: () -> T): JsDeclarationSyntax<C> =
    block().declare(Var)