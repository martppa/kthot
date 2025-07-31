package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition

class JsBooleanRef(
    name: String? = null,
    isNullable: Boolean = false
) : JsBoolean, net.asere.kotlin.js.dsl.type.reference.JsValueRef<JsBoolean>(
    name = name ?: "boolean_${_root_ide_package_.net.asere.kotlin.js.dsl.type.reference.ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun JsBoolean.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsBooleanRef(name, isNullable)

fun JsBoolean.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsBooleanRef, JsBoolean>() {
        override val reference: JsBooleanRef = JsBooleanRef(name, isNullable)
    }