package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.value.JsValue

class JsVarDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("var $jsObject")

@JsDsl
fun <T : JsValue> JsScriptScope.Var(block: () -> JsDeclarableReference<T>) = block().declare(Var)