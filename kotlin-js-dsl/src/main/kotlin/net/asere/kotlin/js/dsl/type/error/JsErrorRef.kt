package net.asere.kotlin.js.dsl.type.error

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsErrorRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsError, JsValueRef<JsError>(
    name = name ?: "error_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsError.Companion.ref(name: String? = null, isNullable: Boolean = false): JsError = JsErrorRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsError.Companion.ref(element: JsElement, isNullable: Boolean = false): JsError =
    JsErrorRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsError.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsErrorRef, JsError>() {
        override val reference: JsErrorRef = JsErrorRef(name, isNullable)
    }