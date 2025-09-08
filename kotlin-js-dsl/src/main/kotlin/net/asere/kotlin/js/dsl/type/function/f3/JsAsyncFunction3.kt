package net.asere.kotlin.js.dsl.type.function.f3

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue> JsScope.Async(
    block: JsScope.() -> JsFunction3Ref<Param1, Param2, Param3>
): JsAsyncFunction3Ref<Param1, Param2, Param3> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction3Ref(name = ref.name)
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction3Ref<Param1, Param2, Param3, Result>
): JsAsyncResultFunction3Ref<Param1, Param2, Param3, Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction3Ref(name = ref.name, resultTypeBuilder = ref.resultTypeBuilder)
}