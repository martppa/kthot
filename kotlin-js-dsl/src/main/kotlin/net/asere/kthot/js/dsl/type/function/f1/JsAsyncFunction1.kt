package net.asere.kthot.js.dsl.type.function.f1

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.value.JsValue

@JsDsl
fun <Param1 : JsValue> JsScope.Async(block: JsScope.() -> JsFunction1Ref<Param1>): JsAsyncFunction1Ref<Param1> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction1Ref(name = ref.refName)
}

@JsDsl
fun <Param1 : JsValue, Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction1Ref<Param1, Result>
): JsAsyncResultFunction1Ref<Param1, Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction1Ref(name = ref.refName, resultTypeBuilder = ref.resultTypeBuilder)
}