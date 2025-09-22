package net.asere.kotlin.js.dsl.dom.type.document

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

object Document : JsDocumentRef("document")

open class JsDocumentRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDocument>(
    name ?: "document_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDocument, JsReference<JsDocument> {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsDocument.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDocumentRef =
    JsDocumentRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsDocument.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDocumentRef, JsDocument>() {
        override val reference: JsDocumentRef = JsDocumentRef(name = name, isNullable)
    }