package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsErrorRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsError, JsValueRef<JsError>(
    name = name ?: "error_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsError.Companion.ref(name: String? = null, isNullable: Boolean = false): JsError = JsErrorRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsError.Companion.ref(element: JsElement, isNullable: Boolean = false): JsError =
    JsErrorRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsError.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsErrorRef, JsError>() {
        override val reference: JsErrorRef = JsErrorRef(name, isNullable)
    }