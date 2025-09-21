package net.asere.kotlin.js.dsl.dom.type.form

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsFormRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsForm>(
    name ?: "form_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsForm, JsReference<JsForm> {
    override fun toString(): String = present()
}

fun JsForm.Companion.ref(name: String? = null, isNullable: Boolean = false): JsFormRef =
    JsFormRef(name, isNullable)

fun JsForm.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsFormRef, JsForm>() {
        override val reference: JsFormRef = JsFormRef(name = name, isNullable)
    }