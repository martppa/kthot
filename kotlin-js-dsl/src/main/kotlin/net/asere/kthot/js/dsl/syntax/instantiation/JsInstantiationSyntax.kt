package net.asere.kthot.js.dsl.syntax.instantiation

import net.asere.kthot.js.dsl.syntax.JsSyntax

class JsInstantiationSyntax(value: Instantiable) : JsSyntax("new $value")