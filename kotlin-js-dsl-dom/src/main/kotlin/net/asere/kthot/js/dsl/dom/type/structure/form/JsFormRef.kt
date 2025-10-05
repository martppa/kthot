package net.asere.kthot.js.dsl.dom.type.structure.form

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsFormRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsForm>(
    name ?: "form_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsForm, JsReference<JsForm> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsForm.Companion.ref(name: String? = null, isNullable: Boolean = false): JsFormRef =
    JsFormRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsForm.Companion.ref(element: JsElement, isNullable: Boolean = false): JsFormRef =
    JsFormRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsForm.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsFormRef, JsForm>() {
        override val reference: JsFormRef = JsFormRef(name = name, isNullable)
    }