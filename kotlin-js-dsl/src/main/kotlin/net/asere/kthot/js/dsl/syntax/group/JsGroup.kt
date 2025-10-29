@file:Suppress("TYPE_INTERSECTION_AS_REIFIED_WARNING")

package net.asere.kthot.js.dsl.syntax.group

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

inline fun <reified T> JsScope.group(typeBuilder: (JsElement) -> T = ::provide, block: () -> T): T =
    typeBuilder(JsGroupSyntax(JsSyntax("${block()}")))

inline fun <reified T> T.group(typeBuilder: (JsElement) -> T = ::provide): T =
    typeBuilder(JsGroupSyntax(JsSyntax("$this")))

inline fun <reified T> T.groupIfGroupable(): T = if (this is Groupable) this.group() else this