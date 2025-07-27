package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsHistory
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef
import net.asere.kotlin.js.dsl.types.reference.ReferenceId

class JsHistoryRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsHistory>(
    name ?: "history_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsHistory, JsReference<JsHistory> {
    override fun toString(): String = present()
}

fun JsHistory.Companion.ref(name: String? = null, isNullable: Boolean = false) = JsHistoryRef(name, isNullable)

fun JsHistory.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsHistoryRef, JsHistory>() {
    override val reference: JsHistoryRef = JsHistoryRef(name)
}