package net.asere.kthot.js.dsl.syntax.instantiation

import net.asere.kthot.js.dsl.tag.JsDsl

@JsDsl
fun <T : Instantiable> new(block: () -> T): JsInstantiationSyntax = JsInstantiationSyntax(value = block())