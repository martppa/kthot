package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.value.JsValue

inline fun <reified T : JsValue> JsScope.await(
    resultTypeBuilder: (JsElement, Boolean) -> T = ::provide,
    block: JsScope.() -> JsPromise<T>
): T = resultTypeBuilder(JsAwaitSyntax(block()), false) // TODO: Apply improvement to nullable types

@JsDsl
inline fun <reified T : JsValue> JsScope.Await(
    block: JsScope.() -> JsPromise<T>
): T = await(block = block).apply { +this }