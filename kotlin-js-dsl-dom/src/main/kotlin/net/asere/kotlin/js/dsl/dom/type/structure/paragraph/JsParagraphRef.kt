package net.asere.kotlin.js.dsl.dom.type.structure.paragraph

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsParagraphRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsParagraph>(
    name ?: "paragraph_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsParagraph, JsReference<JsParagraph> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.ref(name: String? = null, isNullable: Boolean = false): JsParagraphRef =
    JsParagraphRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.ref(element: JsElement, isNullable: Boolean = false): JsParagraphRef =
    JsParagraphRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsParagraph.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsParagraphRef, JsParagraph>() {
        override val reference: JsParagraphRef = JsParagraphRef(name = name, isNullable)
    }