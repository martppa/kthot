package net.asere.kthot.js.dsl.type.string

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsStringRef @JsInternalApi constructor(
    name: String? = null,
) : JsString, JsValueRef<JsString>(
    name = name ?: "string_${ReferenceId.nextRefInt()}",
) {
    override fun toString(): String = present()

    override fun stringify(): String = $$$"${$$${super.refName}}"
}

@OptIn(JsInternalApi::class)
fun JsString.Companion.ref(name: String? = null): JsStringRef =
    JsStringRef(name)

@OptIn(JsInternalApi::class)
fun JsString.Companion.ref(element: JsElement): JsStringRef =
    JsStringRef(element.present())

@OptIn(JsInternalApi::class)
fun JsString.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsStringRef, JsString>() {
        override val reference: JsStringRef = JsStringRef(name)
    }