package net.asere.kotlin.js.dsl.type.function.f4

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.function.f3.JsAsyncFunction3Ref
import net.asere.kotlin.js.dsl.type.function.f3.JsAsyncResultFunction3Ref
import net.asere.kotlin.js.dsl.type.function.f3.JsFunction3Ref
import net.asere.kotlin.js.dsl.type.function.f3.JsResultFunction3Ref
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue> JsScope.Async(
    block: JsScope.() -> JsFunction4Ref<Param1, Param2, Param3, Param4>
): JsAsyncFunction4Ref<Param1, Param2, Param3, Param4> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction4Ref(name = ref.name)
}

@JsDsl
fun <Param1 : JsValue, Param2 : JsValue, Param3 : JsValue, Param4 : JsValue, Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction4Ref<Param1, Param2, Param3, Param4, Result>
): JsAsyncResultFunction4Ref<Param1, Param2, Param3, Param4, Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction4Ref(name = ref.name, resultTypeBuilder = ref.resultTypeBuilder)
}