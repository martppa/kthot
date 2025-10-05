package net.asere.kthot.js.dsl.syntax.jstry

import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.error.JsError

fun jsThrow(error: JsError) = JsSyntax("throw $error")

@JsDsl
fun JsScope.Throw(block: JsScope.() -> JsError) = +jsThrow(block())