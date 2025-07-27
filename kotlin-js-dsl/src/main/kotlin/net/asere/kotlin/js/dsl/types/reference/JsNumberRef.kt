package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.type.JsNumber

class JsNumberRef internal constructor(
    name: String? = null
) : JsNumber, JsReference<JsNumber> by JsValueRef(
    name = name ?: "number_${JsReference.nextRefInt()}"
) {
    override fun toString(): String = present()
}

fun JsNumber.Companion.ref(name: String? = null): JsNumberRef = JsNumberRef(name)

fun JsNumber.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsNumberRef, JsNumber>() {
    override val reference: JsNumberRef = JsNumberRef(name)
}