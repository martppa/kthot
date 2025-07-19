package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.comparison.Comparable
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString

interface JsValue : JsElement, Comparable

fun JsValue.raw(syntax: JsSyntax) = JsSyntax("$this.$syntax")
fun JsValue.raw(syntax: String) = JsSyntax("$this.$syntax")
operator fun JsValue.get(value: JsNumber) = JsSyntax("$this[$value]")
operator fun JsValue.get(value: JsString) = JsSyntax("$this[$value]")
operator fun JsValue.get(value: JsValue) = JsSyntax("$this[$value]")
operator fun JsValue.plus(value: JsValue) = JsSyntax("$this + $value")
operator fun JsValue.minus(value: JsValue) = JsSyntax("$this - $value")
operator fun JsValue.times(value: JsValue) = JsSyntax("$this * $value")
operator fun JsValue.div(value: JsValue) = JsSyntax("$this / $value")
operator fun JsValue.rem(value: JsValue) = JsSyntax("$this % $value")