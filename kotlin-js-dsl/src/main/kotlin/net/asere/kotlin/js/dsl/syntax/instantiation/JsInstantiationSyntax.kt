package net.asere.kotlin.js.dsl.syntax.instantiation

import net.asere.kotlin.js.dsl.syntax.JsSyntax

class JsInstantiationSyntax(value: Instantiable) : JsSyntax("new $value")