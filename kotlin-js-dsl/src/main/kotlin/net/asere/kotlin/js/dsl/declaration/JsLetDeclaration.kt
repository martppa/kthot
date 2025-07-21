package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.value.JsValue

class JsLetDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("let $jsObject")

@JsDsl
fun <T : JsValue> JsScriptScope.Let(block: () -> JsDeclarableReference<T>) = block().declare(Let)