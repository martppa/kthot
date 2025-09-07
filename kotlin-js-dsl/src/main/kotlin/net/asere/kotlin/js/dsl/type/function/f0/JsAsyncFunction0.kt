package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun JsScope.Async(block: JsScope.() -> JsFunction0Ref): JsAsyncFunction0Ref {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction0Ref(name = ref.name)
}

@JsDsl
fun <Result : JsValue> JsScope.AsyncResult(
    block: JsScope.() -> JsResultFunction0Ref<Result>
): JsAsyncResultFunction0Ref<Result> {
    val scope = JsSyntaxScope()
    val ref = block(scope)
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction0Ref(name = ref.name, resultTypeBuilder = ref.resultTypeBuilder)
}