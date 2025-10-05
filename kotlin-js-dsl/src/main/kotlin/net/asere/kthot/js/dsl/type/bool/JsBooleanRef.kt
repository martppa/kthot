package net.asere.kthot.js.dsl.type.bool

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsBooleanRef @JsInternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsBoolean, net.asere.kthot.js.dsl.type.reference.JsValueRef<JsBoolean>(
    name = name ?: "boolean_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(JsInternalApi::class)
fun JsBoolean.Companion.ref(name: String? = null, isNullable: Boolean = false): JsBooleanRef =
    JsBooleanRef(name, isNullable)

@OptIn(JsInternalApi::class)
fun JsBoolean.Companion.ref(element: JsElement, isNullable: Boolean = false): JsBooleanRef =
    JsBooleanRef(element.present(), isNullable)

@OptIn(JsInternalApi::class)
fun JsBoolean.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsBooleanRef, JsBoolean>() {
        override val reference: JsBooleanRef = JsBooleanRef(name, isNullable)
    }