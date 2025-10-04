package net.asere.kotlin.js.dsl.dom.type.structure.div

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsDivRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDiv>(
    name ?: "div_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDiv, JsReference<JsDiv> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDivRef =
    JsDivRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.ref(element: JsElement, isNullable: Boolean = false): JsDivRef =
    JsDivRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDivRef, JsDiv>() {
        override val reference: JsDivRef = JsDivRef(name = name, isNullable)
    }