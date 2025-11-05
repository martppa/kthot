package net.asere.kthot.js.dsl.sample.snippets

import net.asere.kthot.js.dsl.log.Console
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.jstry.Catch
import net.asere.kthot.js.dsl.syntax.jstry.Finally
import net.asere.kthot.js.dsl.syntax.jstry.Throw
import net.asere.kthot.js.dsl.syntax.jstry.Try
import net.asere.kthot.js.dsl.syntax.jstry.jsCatch
import net.asere.kthot.js.dsl.syntax.jstry.jsFinally
import net.asere.kthot.js.dsl.syntax.jstry.jsThrow
import net.asere.kthot.js.dsl.syntax.jstry.jsTry
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.error.def
import net.asere.kthot.js.dsl.type.error.new

fun main(vararg args: String) {
    val syntax = js {
        +jsTry {
            +Console.log("From inside a try")
            +jsThrow(JsError.new("Thrown error"))
        }.jsCatch(JsError.def("error")) {
            Log("Caught error: $it")
        }.jsFinally {
            Log("Finally clause")
        }

        Try {
            Log("From inside a try")
            Throw { JsError.new("Thrown error") }
        }
        Catch(JsError.def("error")) {
            Log("Caught error: $it")
        }
        Finally {
            Log("Finally clause")
        }
    }
    println(syntax)
}