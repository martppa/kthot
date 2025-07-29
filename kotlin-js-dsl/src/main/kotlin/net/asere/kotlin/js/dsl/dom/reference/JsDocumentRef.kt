package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsDocument
import net.asere.kotlin.js.dsl.dom.type.JsDomObject
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

object Document : JsDocumentRef("document")

open class JsDocumentRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDocument>(
    name ?: "document_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDocument, JsReference<JsDocument> {
    override fun toString(): String = present()
}

fun JsDocument.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsDocumentRef(name, isNullable)

fun JsDocument.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDomObjectRef, JsDomObject>() {
        override val reference: JsDomObjectRef = JsDomObjectRef(name = name, isNullable)
    }