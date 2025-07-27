package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsNumber

class JsNumberRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsNumber, JsValueRef<JsNumber>(
    name = name ?: "number_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun JsNumber.Companion.ref(name: String? = null, isNullable: Boolean = false): JsNumberRef =
    JsNumberRef(name, isNullable)

fun JsNumber.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsNumberRef, JsNumber>() {
        override val reference: JsNumberRef = JsNumberRef(name, isNullable)
    }