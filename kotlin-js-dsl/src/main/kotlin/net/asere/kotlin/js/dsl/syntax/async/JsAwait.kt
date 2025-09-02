package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun JsScope.await(block: JsScope.() -> JsAsyncCallable): JsAwaitSyntax =
    JsAwaitSyntax(block())