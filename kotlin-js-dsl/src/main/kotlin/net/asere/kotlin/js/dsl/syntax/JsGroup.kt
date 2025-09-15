package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.value.JsValue

inline fun <reified T : JsValue> JsScope.group(typeBuilder: (JsElement, Boolean) -> T = ::provide, block: () -> T): T =
    typeBuilder(JsSyntax("(${block()})"), false)