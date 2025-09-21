package net.asere.kotlin.js.dsl.dom.type.form.button

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsButtonRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsButton>(
    name ?: "button_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsButton, JsReference<JsButton> {
    override fun toString(): String = present()
}

fun JsButton.Companion.ref(name: String? = null, isNullable: Boolean = false): JsButtonRef =
    JsButtonRef(name, isNullable)

fun JsButton.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsButtonRef, JsButton>() {
        override val reference: JsButtonRef = JsButtonRef(name = name, isNullable)
    }