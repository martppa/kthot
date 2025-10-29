package net.asere.kthot.js.dsl.dom.type.structure.div

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsDivRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsDiv>(
    name ?: "div_${ReferenceId.nextRefInt()}",
    
), JsDiv, JsReference<JsDiv> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.ref(name: String? = null): JsDivRef =
    JsDivRef(name)

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.ref(element: JsElement): JsDivRef =
    JsDivRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDiv.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsDivRef, JsDiv>() {
        override val reference: JsDivRef = JsDivRef(name = name)
    }