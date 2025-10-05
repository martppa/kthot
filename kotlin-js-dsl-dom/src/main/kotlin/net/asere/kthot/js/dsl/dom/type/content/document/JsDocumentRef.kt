package net.asere.kthot.js.dsl.dom.type.content.document

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

object Document : JsDocumentRef("document")

open class JsDocumentRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDocument>(
    name ?: "document_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDocument, JsReference<JsDocument> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDocument.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDocumentRef =
    JsDocumentRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsDocument.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDocumentRef, JsDocument>() {
        override val reference: JsDocumentRef = JsDocumentRef(name = name, isNullable)
    }