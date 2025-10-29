package net.asere.kthot.js.dsl.dom.type.window.history

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsHistoryRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsHistory>(
    name ?: "history_${ReferenceId.nextRefInt()}",
    
), JsHistory, JsReference<JsHistory> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.ref(name: String? = null): JsHistoryRef =
    JsHistoryRef(name)

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.ref(element: JsElement): JsHistoryRef =
    JsHistoryRef(element.present())

@OptIn(JsInternalApi::class)
fun JsHistory.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsHistoryRef, JsHistory>() {
        override val reference: JsHistoryRef = JsHistoryRef(name)
    }