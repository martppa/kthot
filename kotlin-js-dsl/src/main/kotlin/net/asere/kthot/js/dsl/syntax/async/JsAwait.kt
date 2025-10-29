package net.asere.kthot.js.dsl.syntax.async

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.value.JsValue

inline fun <reified T : JsValue> JsScope.await(
    resultTypeBuilder: (JsElement) -> T = ::provide,
    block: JsScope.() -> JsPromise<T>
): T = resultTypeBuilder(JsAwaitSyntax(block()))

@JsDsl
inline fun <reified T : JsValue> JsScope.Await(
    block: JsScope.() -> JsPromise<T>
): T = await(block = block).apply { +this }