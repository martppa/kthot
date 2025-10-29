package net.asere.kthot.js.dsl.dom.type.structure.paragraph

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsParagraphRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsParagraph>(
    name ?: "paragraph_${ReferenceId.nextRefInt()}",
    
), JsParagraph, JsReference<JsParagraph> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.ref(name: String? = null): JsParagraphRef =
    JsParagraphRef(name)

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.ref(element: JsElement): JsParagraphRef =
    JsParagraphRef(element.present())

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsParagraphRef, JsParagraph>() {
        override val reference: JsParagraphRef = JsParagraphRef(name = name)
    }