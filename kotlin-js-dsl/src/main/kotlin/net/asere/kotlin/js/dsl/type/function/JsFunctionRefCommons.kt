package net.asere.kotlin.js.dsl.type.function

import net.asere.kotlin.js.dsl.type.`object`.JsObjectRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

abstract class JsFunctionRefCommons(
    name: String? = null,
) : JsObjectRef(name ?: "function_${ReferenceId.nextRefInt()}") {
    override fun toString(): String = present()
}