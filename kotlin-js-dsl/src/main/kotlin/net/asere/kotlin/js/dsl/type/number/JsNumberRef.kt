package net.asere.kotlin.js.dsl.type.number

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsNumberRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsNumber, JsValueRef<JsNumber>(
    name = name ?: "number_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsNumber.Companion.ref(name: String? = null, isNullable: Boolean = false): JsNumberRef =
    JsNumberRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsNumber.Companion.ref(element: JsElement, isNullable: Boolean = false): JsNumberRef =
    JsNumberRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsNumber.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsNumberRef, JsNumber>() {
        override val reference: JsNumberRef = JsNumberRef(name, isNullable)
    }