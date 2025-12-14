package net.asere.kthot.js.dsl.dom.type.core.node

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.reference.JsValueRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsNodeRef @JsInternalApi constructor(
    name: String? = null,
) : JsValueRef<JsNode>(
    name ?: "node_object_${ReferenceId.nextRefInt()}",
), JsNode, JsReference<JsNode> {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsNode.Companion.ref(name: String? = null): JsNodeRef =
    JsNodeRef(name)

@OptIn(JsInternalApi::class)
fun JsNode.Companion.def(name: String? = null) = object :
    JsPrintableDefinition<JsNodeRef, JsNode>() {
    override val reference: JsNodeRef = JsNodeRef(name)
}