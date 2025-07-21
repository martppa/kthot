package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.value.JsValue

class JsVarDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("var $jsObject")

@JsDsl
fun <T : JsDeclarableReference<C>, C : JsValue> JsScriptScope.Var(block: () -> T): JsSyntaxBuilder<T> =
    block().declare(Var)