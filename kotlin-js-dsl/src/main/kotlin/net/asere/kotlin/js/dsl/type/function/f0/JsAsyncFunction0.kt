package net.asere.kotlin.js.dsl.type.function.f0

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.function.Function
import net.asere.kotlin.js.dsl.type.function.ResultFunction
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.value.JsValue

@JsDsl
fun JsScope.AsyncFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    definition: JsScope.() -> Unit
): JsAsyncFunction0Ref {
    val scope = JsSyntaxScope()
    scope.run {
        Function {
            definition()
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncFunction0Ref(name = name)
}

@JsDsl
inline fun <reified Result : JsValue> JsScope.AsyncResultFunction(
    name: String = "function_${ReferenceId.nextRefInt()}",
    crossinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    crossinline definition: JsSyntaxScope.() -> Result,
): JsAsyncResultFunction0Ref<Result> {
    val scope = JsSyntaxScope()
    scope.run {
        ResultFunction<Result> {
            definition()
        }
    }
    +JsAsyncSyntax(value = scope)
    return JsAsyncResultFunction0Ref(
        name = name,
        resultTypeBuilder = { syntax ->
            resultTypeBuilder(
                syntax,
                with(JsSyntaxScope().run { definition() }) {
                    this is JsReference<*> && this.isNullable
                }
            )
        },
    )
}