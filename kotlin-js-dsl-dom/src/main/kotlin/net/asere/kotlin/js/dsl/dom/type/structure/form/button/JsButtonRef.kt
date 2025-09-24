package net.asere.kotlin.js.dsl.dom.type.structure.form.button

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsButtonRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsButton>(
    name ?: "button_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsButton, JsReference<JsButton> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsButton.Companion.ref(name: String? = null, isNullable: Boolean = false): JsButtonRef =
    JsButtonRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsButton.Companion.ref(element: JsElement, isNullable: Boolean = false): JsButtonRef =
    JsButtonRef(element.present(), isNullable)

@OptIn(InternalApi::class)
fun JsButton.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsButtonRef, JsButton>() {
        override val reference: JsButtonRef = JsButtonRef(name = name, isNullable)
    }