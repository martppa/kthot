package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.types.type.JsPromise
import net.asere.kotlin.js.dsl.types.value.JsValue

@JsDsl
fun <T : JsValue > JsScriptScope.await(block: () -> JsPromise<T>): JsAwaitSyntax<T> =
    JsAwaitSyntax(block())