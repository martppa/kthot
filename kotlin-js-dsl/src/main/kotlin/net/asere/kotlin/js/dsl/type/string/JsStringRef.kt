package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsStringRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsString, JsValueRef<JsString>(
    name = name ?: "string_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()

    override fun stringify(): String = $$$"${$$${super.name}}"
}

@OptIn(JsInternalApi::class)
fun JsString.Companion.ref(name: String? = null, isNullable: Boolean = false): JsStringRef =
    JsStringRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsString.Companion.ref(element: JsElement, isNullable: Boolean = false): JsStringRef =
    JsStringRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsString.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsStringRef, JsString>() {
        override val reference: JsStringRef = JsStringRef(name, isNullable)
    }