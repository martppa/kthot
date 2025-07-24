package net.asere.kotlin.js.dsl.dom.reference

import net.asere.kotlin.js.dsl.dom.type.JsHistory
import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.JsReference
import net.asere.kotlin.js.dsl.reference.JsValueRef

class JsHistoryRef internal constructor(
    name: String? = null
) : JsValueRef<JsHistory>(
    name ?: "history_${JsReference.nextRefInt()}"
), JsHistory, JsDeclarableReference<JsHistory> {
    override fun toString(): String = present()
}