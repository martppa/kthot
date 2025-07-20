package net.asere.kotlin.js.dsl

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.callable.JsFunction
import net.asere.kotlin.js.dsl.dom.reference.JsWindow
import net.asere.kotlin.js.dsl.html.jsScript
import net.asere.kotlin.js.dsl.reference.JsFunction1Ref
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.type.JsString
import net.asere.kotlin.js.dsl.type.js

fun main(vararg args: String) {
    val showAlert = JsFunction1Ref<JsString>("showAlert")
    val result = createHTML().html {
        head {
            jsScript {
                +JsFunction(name = "showAlert", JsString.ref()) {
                    +JsWindow.alert(it)
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