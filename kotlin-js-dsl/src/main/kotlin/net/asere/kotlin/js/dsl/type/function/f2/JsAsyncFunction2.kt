package net.asere.kotlin.js.dsl.type.function.f2

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue> JsScope.Async(block: JsScope.() -> JsFunction2Ref<Param1, Param2>): JsAsyncFunction2Ref<Param1, Param2> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction2Ref(name = ref.name)
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction2Ref<Param1, Param2, Result>
): JsAsyncResultFunction2Ref<Param1, Param2, Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction2Ref(name = ref.name, resultTypeBuilder = ref.resultTypeBuilder)
}