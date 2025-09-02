package net.asere.kotlin.js.dsl.syntax.jstry

import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.error.JsError

fun jsThrow(error: JsError) = JsSyntax("throw $error")

@JsDsl
fun JsScope.Throw(block: JsScope.() -> JsError) = +jsThrow(block())