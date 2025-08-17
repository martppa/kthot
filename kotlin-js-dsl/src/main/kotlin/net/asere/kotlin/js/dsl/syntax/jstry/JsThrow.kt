package net.asere.kotlin.js.dsl.syntax.jstry

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.error.JsError

fun jsThrow(error: JsError) = JsSyntax("throw $error")

@JsDsl
fun JsScriptScope.Throw(block: JsScriptScope.() -> JsError) = +jsThrow(block())