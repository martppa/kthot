package net.asere.kotlin.js.dsl.dom.type.form.validity

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsValidityStateRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsValidityState>(
    name ?: "validitystate_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsValidityState, JsReference<JsValidityState> {
    override fun toString(): String = present()
}

fun JsValidityState.Companion.ref(name: String? = null, isNullable: Boolean = false): JsValidityStateRef =
    JsValidityStateRef(name, isNullable)

fun JsValidityState.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsValidityStateRef, JsValidityState>() {
        override val reference: JsValidityStateRef = JsValidityStateRef(name = name, isNullable)
    }