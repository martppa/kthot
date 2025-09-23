package net.asere.kotlin.js.dsl.dom.type.data.token.list

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

open class JsDomTokenListRef internal constructor(
    name: String? = null,
    isNullable: Boolean = false,
) : JsValueRef<JsDomTokenList>(
    name ?: "token_list_${ReferenceId.nextRefInt()}",
    isNullable = isNullable,
), JsDomTokenList, JsReference<JsDomTokenList> {
    override fun toString(): String = present()
}

fun JsDomTokenList.Companion.ref(name: String? = null, isNullable: Boolean = false): JsDomTokenListRef =
    JsDomTokenListRef(name, isNullable)

fun JsDomTokenList.Companion.def(name: String? = null, isNullable: Boolean = false) =
    object : JsPrintableDefinition<JsDomTokenListRef, JsDomTokenList>() {
        override val reference: JsDomTokenListRef = JsDomTokenListRef(name = name, isNullable)
    }