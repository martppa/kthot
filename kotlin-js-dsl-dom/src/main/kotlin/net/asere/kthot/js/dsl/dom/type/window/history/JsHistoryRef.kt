package net.asere.kthot.js.dsl.dom.type.window.history

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsHistoryRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsValueRef<JsHistory>(
    name ?: "history_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsHistory, JsReference<JsHistory> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.ref(name: String? = null, isNullable: Boolean = false): JsHistoryRef =
    JsHistoryRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.ref(element: JsElement, isNullable: Boolean = false): JsHistoryRef =
    JsHistoryRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsHistoryRef, JsHistory>() {
        override val reference: JsHistoryRef = JsHistoryRef(name, isNullable)
    }