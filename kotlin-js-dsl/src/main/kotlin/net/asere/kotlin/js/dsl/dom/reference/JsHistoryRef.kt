package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsHistory
import net.asere.kotlin.js.dsl.types.definition.JsDefinition
import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.JsReference
import net.asere.kotlin.js.dsl.types.reference.JsValueRef

class JsHistoryRef internal constructor(
    name: String? = null
) : JsValueRef<JsHistory>(
    name ?: "history_${JsReference.nextRefInt()}"
), JsHistory, JsReference<JsHistory> {
    override fun toString(): String = present()
}

fun JsHistory.Companion.ref(name: String? = null) = JsHistoryRef(name)

fun JsHistory.Companion.def(name: String? = null) = object : JsPrintableDefinition<JsHistoryRef, JsHistory>() {
    override val reference: JsHistoryRef = JsHistoryRef(name)
}