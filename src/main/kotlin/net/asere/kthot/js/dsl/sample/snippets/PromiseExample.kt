package net.asere.kthot.js.dsl.sample.snippets

import kotlinx.html.body
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.ksp.Kthot
import net.asere.kthot.js.dsl.provider.register
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch.JsResponse
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch.syntax
import net.asere.kthot.js.dsl.sample.app.scrirpt.model.JsRepo
import net.asere.kthot.js.dsl.syntax.async.Await
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.def
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.def
import net.asere.kthot.js.dsl.type.promise.new
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.value

fun main(vararg args: String) {
    val result = createHTML().body {
        jslScript {
            register { element -> JsArray.syntax<JsRepo>(value = element) }
            register { element -> JsResponse.syntax<JsArray<JsRepo>>(value = element) }
            Kthot.initialize()
            val promise = Const { JsPromise.def<JsString>("promise") } assign JsPromise.new(
                jsLambda(
                    param1 = JsLambda1.def("onResolve"),
                    param2 = JsLambda1.def("onError")
                ) { onResolve, onError ->
                    +onResolve(JsString.value("Emitted with in promise"))
                }
            )
            Await { promise }
        }
    }
    println(result)
}