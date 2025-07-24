package net.asere.kotlin.js.dsl.types.type

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.operation.LogicalComparable
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.reference.JsBooleanRef
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.value.JsValue
import net.asere.kotlin.js.dsl.types.value.value

interface JsBoolean : JsValue, LogicalComparable {

    fun jsToString(): JsSyntax = JsSyntax("${this}.toString()")

    companion object
}

val Boolean.js: JsBoolean get() = JsBoolean.value(this)