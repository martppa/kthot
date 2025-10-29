package net.asere.kthot.js.dsl.dom.type.data.token.list

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

open class JsDomTokenListRef @JsInternalApi constructor(
    name: String? = null,
    
) : JsValueRef<JsDomTokenList>(
    name ?: "token_list_${ReferenceId.nextRefInt()}",
    
), JsDomTokenList, JsReference<JsDomTokenList> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsDomTokenList.Companion.ref(name: String? = null): JsDomTokenListRef =
    JsDomTokenListRef(name)

@OptIn(JsInternalApi::class)
fun JsDomTokenList.Companion.ref(element: JsElement): JsDomTokenListRef =
    JsDomTokenListRef(element.present())

@OptIn(JsInternalApi::class)
fun JsDomTokenList.Companion.def(name: String? = null) =
    object : JsPrintableDefinition<JsDomTokenListRef, JsDomTokenList>() {
        override val reference: JsDomTokenListRef = JsDomTokenListRef(name = name)
    }