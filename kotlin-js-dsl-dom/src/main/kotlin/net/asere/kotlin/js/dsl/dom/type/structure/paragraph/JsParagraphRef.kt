package net.asere.kotlin.js.dsl.dom.type.structure.paragraph

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsParagraphRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsParagraph>(
    name ?: "paragraph_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsParagraph, JsReference<JsParagraph> {
    override fun toString(): String = present()
}

fun JsParagraph.Companion.ref(name: String? = null, isNullable: Boolean = false): JsParagraphRef =
    JsParagraphRef(name, isNullable)

fun JsParagraph.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsParagraphRef, JsParagraph>() {
        override val reference: JsParagraphRef = JsParagraphRef(name = name, isNullable)
    }