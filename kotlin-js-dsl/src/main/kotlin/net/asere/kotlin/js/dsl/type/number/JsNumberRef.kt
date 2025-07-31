package net.asere.kotlin.js.dsl.type.number

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsNumberRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsNumber, net.asere.kotlin.js.dsl.type.reference.JsValueRef<JsNumber>(
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