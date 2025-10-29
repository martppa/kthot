package net.asere.kthot.js.dsl.type.error

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsErrorRef @JsInternalApi constructor(
    name: String? = null,
) : JsError, JsValueRef<JsError>(
    name = name ?: "error_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsError.Companion.ref(name: String? = null): JsError = JsErrorRef(name)

@OptIn(JsInternalApi::class)
fun JsError.Companion.ref(element: JsElement): JsError =
    JsErrorRef(element.present())

@OptIn(JsInternalApi::class)
fun JsError.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsErrorRef, JsError>() {
        override val reference: JsErrorRef = JsErrorRef(name)
    }