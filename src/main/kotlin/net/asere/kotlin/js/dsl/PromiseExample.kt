package net.asere.kotlin.js.dsl

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.html.jslScript
import net.asere.kotlin.js.dsl.syntax.async.await
import net.asere.kotlin.js.dsl.syntax.instantiation.new
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.l2.jsLambda
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.def
import net.asere.kotlin.js.dsl.type.promise.jsPromise
import net.asere.kotlin.js.dsl.type.lambda.l1.def
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            val promise = Const { JsPromise.def<JsString>("promise") } assign new {
                jsPromise(
                    lambda = jsLambda(
                        param1 = JsLambda1.def("onResolve"),
                        param2 = JsLambda1.def("onError"),
                        definition = { onResolve, onError ->
                            +onResolve(JsString.value("Emitted with in promise"))
                        }
                    ),
                )
            }
            await { promise }
        }
    }
    println(result)
}