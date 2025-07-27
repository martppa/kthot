package net.asere.kotlin.js.dsl.syntax.instantiation

import net.asere.kotlin.js.dsl.tag.JsDsl

@JsDsl
fun <T : Instantiable> new(block: () -> T): JsInstantiationSyntax = JsInstantiationSyntax(value = block())