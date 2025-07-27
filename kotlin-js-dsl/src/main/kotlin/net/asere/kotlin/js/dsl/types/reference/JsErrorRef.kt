package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsError

class JsErrorRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsError, JsValueRef<JsError>(
    name = name ?: "error_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

fun JsError.Companion.ref(name: String? = null, isNullable: Boolean = false): JsError = JsErrorRef(name, isNullable)

fun JsError.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsErrorRef, JsError>() {
        override val reference: JsErrorRef = JsErrorRef(name, isNullable)
    }