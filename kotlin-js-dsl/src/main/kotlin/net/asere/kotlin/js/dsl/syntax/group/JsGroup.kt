@file:Suppress("TYPE_INTERSECTION_AS_REIFIED_WARNING")

package net.asere.kotlin.js.dsl.syntax.group

import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

inline fun <reified T> JsScope.group(typeBuilder: (JsElement, Boolean) -> T = ::provide, block: () -> T): T =
    typeBuilder(JsGroupSyntax(JsSyntax("${block()}")), false)

inline fun <reified T> T.group(typeBuilder: (JsElement, Boolean) -> T = ::provide): T =
    typeBuilder(JsGroupSyntax(JsSyntax("$this")), false)

inline fun <reified T> T.groupIfGroupable(): T = if (this is Groupable) this.group() else this