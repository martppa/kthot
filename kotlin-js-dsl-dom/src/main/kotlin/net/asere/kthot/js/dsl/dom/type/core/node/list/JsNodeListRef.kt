package net.asere.kthot.js.dsl.dom.type.core.node.list

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.dom.type.core.node.JsNode
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsNodeListRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsNodeList>(
    name ?: "node_list_object_${ReferenceId.nextRefInt()}",
), JsNodeList, JsReference<JsNodeList> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsNodeList.Companion.ref(name: String? = null): JsNodeListRef =
    JsNodeListRef(name)

@OptIn(JsInternalApi::class)
fun JsNodeList.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsNodeListRef, JsNodeList>() {
    override val reference: JsNodeListRef = JsNodeListRef(name)
}