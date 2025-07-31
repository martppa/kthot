package net.asere.kotlin.js.dsl.extension

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

operator fun List<JsValue>.unaryPlus() = JsSyntax(joinToString(", "))