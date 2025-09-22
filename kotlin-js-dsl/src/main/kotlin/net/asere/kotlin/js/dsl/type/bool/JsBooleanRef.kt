package net.asere.kotlin.js.dsl.type.bool

import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsBooleanRef @InternalApi constructor(
    name: String? = null,
    isNullable: Boolean = false
) : JsBoolean, net.asere.kotlin.js.dsl.type.reference.JsValueRef<JsBoolean>(
    name = name ?: "boolean_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
) {
    override fun toString(): String = present()
}

@OptIn(InternalApi::class)
fun JsBoolean.Companion.ref(name: String? = null, isNullable: Boolean = false): JsBooleanRef = JsBooleanRef(name, isNullable)

@OptIn(InternalApi::class)
fun JsBoolean.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsBooleanRef, JsBoolean>() {
        override val reference: JsBooleanRef = JsBooleanRef(name, isNullable)
    }