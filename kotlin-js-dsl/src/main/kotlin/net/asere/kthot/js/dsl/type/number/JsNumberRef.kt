package net.asere.kthot.js.dsl.type.number

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsNumberRef @JsInternalApi constructor(
    name: String? = null,
) : JsNumber, JsValueRef<JsNumber>(
    name = name ?: "number_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsNumber.Companion.ref(name: String? = null): JsNumberRef =
    JsNumberRef(name)

@OptIn(JsInternalApi::class)
fun JsNumber.Companion.ref(element: JsElement): JsNumberRef =
    JsNumberRef(element.present())

@OptIn(JsInternalApi::class)
fun JsNumber.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsNumberRef, JsNumber>() {
        override val reference: JsNumberRef = JsNumberRef(name)
    }