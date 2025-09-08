package net.asere.kotlin.js.dsl.type.function.f5

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun <
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue> JsScope.Async(
    block: JsScope.() -> JsFunction5Ref<Param1, Param2, Param3, Param4, Param5>
): JsAsyncFunction5Ref<Param1, Param2, Param3, Param4, Param5> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction5Ref(name = ref.name)
}

@JsDsl
fun <
        Param1 : JsValue,
        Param2 : JsValue,
        Param3 : JsValue,
        Param4 : JsValue,
        Param5 : JsValue,
        Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction5Ref<Param1, Param2, Param3, Param4, Param5, Result>
): JsAsyncResultFunction5Ref<Param1, Param2, Param3, Param4, Param5, Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction5Ref(name = ref.name, resultTypeBuilder = ref.resultTypeBuilder)
}