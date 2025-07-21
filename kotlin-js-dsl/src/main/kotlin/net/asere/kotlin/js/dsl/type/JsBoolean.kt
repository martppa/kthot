package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.LogicalComparable
import net.asere.kotlin.js.dsl.value.JsValue
import net.asere.kotlin.js.dsl.value.value

interface JsBoolean : JsValue, LogicalComparable {

    fun jsToString(): JsSyntax = JsSyntax("${this}.toString()")

    companion object
}

val Boolean.js: JsBoolean get() = JsBoolean.value(this)