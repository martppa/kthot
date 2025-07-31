package net.asere.kotlin.js.dsl

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.dom.type.Window
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.type.function.f1.Function
import net.asere.kotlin.js.dsl.type.function.f1.JsFunction1Ref
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.def
import net.asere.kotlin.js.dsl.type.string.js

fun main(vararg args: String) {
    val showAlert = JsFunction1Ref<JsString>("showAlert")
    val result = createHTML().html {
        head {
            jsScript {
                Function(name = "showAlert", JsString.def()) {
                    +Window.alert(it)
                }
            }
        }
        body {
            button {
                onClick = "${showAlert("Hello World!".js)}"
                +"Click me"
            }
        }
    }
    println(result)
}