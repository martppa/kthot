package net.asere.kthot.js.dsl.extension

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.value.JsValue

operator fun List<JsValue>.unaryPlus() = JsSyntax(joinToString(", "))