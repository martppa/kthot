package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsBoolean

class JsBooleanRef(
    name: String? = null,
    isNullable: Boolean = false
) : JsBoolean, JsValueRef<JsBoolean>(
    name = name ?: "boolean_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun JsBoolean.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsBooleanRef(name, isNullable)

fun JsBoolean.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsBooleanRef, JsBoolean>() {
    override val reference: JsBooleanRef = JsBooleanRef(name)
}