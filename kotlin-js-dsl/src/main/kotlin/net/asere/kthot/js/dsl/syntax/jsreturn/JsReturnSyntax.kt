package net.asere.kthot.js.dsl.syntax.jsreturn

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement

open class JsReturnSyntax internal constructor(value: JsElement? = null) :
    JsSyntax("return${if (value != null) " $value" else ""}")