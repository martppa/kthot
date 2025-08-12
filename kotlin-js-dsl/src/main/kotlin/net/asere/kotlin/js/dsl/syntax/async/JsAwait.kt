package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScriptScope.await(block: JsScriptScope.() -> JsAsyncCallable): JsAwaitSyntax =
    JsAwaitSyntax(block())