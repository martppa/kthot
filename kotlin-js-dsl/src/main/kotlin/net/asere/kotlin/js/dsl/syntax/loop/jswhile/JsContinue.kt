package net.asere.kotlin.js.dsl.syntax.loop.jswhile

import net.asere.kotlin.js.dsl.syntax.JsScriptScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
val JsScriptScope.Continue get() = +jsContinue()

fun jsContinue() = JsSyntax("continue")