package net.asere.kthot.js.dsl.dom.type.html.paragraph

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsParagraphElementRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsParagraphElement>(
    name ?: "paragraph_${ReferenceId.nextRefInt()}",
    
), JsParagraphElement, JsReference<JsParagraphElement> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsParagraphElement.Companion.ref(name: String? = null): JsParagraphElementRef =
    JsParagraphElementRef(name)

@OptIn(JsInternalApi::class)
fun JsParagraphElement.Companion.ref(element: JsElement): JsParagraphElementRef =
    JsParagraphElementRef(element.present())

@OptIn(JsInternalApi::class)
fun JsParagraphElement.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsParagraphElementRef, JsParagraphElement>() {
        override val reference: JsParagraphElementRef = JsParagraphElementRef(name = name)
    }