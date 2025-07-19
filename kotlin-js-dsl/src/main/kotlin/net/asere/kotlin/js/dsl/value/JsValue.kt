package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsArithmeticalSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.comparison.Comparable
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.type.JsString

interface JsValue : JsElement, Comparable

fun JsValue.raw(syntax: JsSyntax) = JsSyntax("$this.$syntax")
fun JsValue.raw(syntax: String) = JsSyntax("$this.$syntax")
operator fun JsValue.get(value: JsNumber) = JsArithmeticalSyntax("$this[$value]")
operator fun JsValue.get(value: JsString) = JsArithmeticalSyntax("$this[$value]")
operator fun JsValue.get(value: JsValue) = JsArithmeticalSyntax("$this[$value]")
operator fun JsValue.plus(value: JsValue) = JsArithmeticalSyntax("$this + $value")
operator fun JsValue.minus(value: JsValue) = JsArithmeticalSyntax("$this - $value")
operator fun JsValue.times(value: JsValue) = JsArithmeticalSyntax("$this * $value")
operator fun JsValue.div(value: JsValue) = JsArithmeticalSyntax("$this / $value")
operator fun JsValue.rem(value: JsValue) = JsArithmeticalSyntax("$this % $value")