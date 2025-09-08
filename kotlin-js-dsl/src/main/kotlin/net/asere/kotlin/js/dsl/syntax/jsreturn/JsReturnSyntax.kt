package net.asere.kotlin.js.dsl.syntax.jsreturn

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

open class JsReturnSyntax internal constructor(value: JsElement? = null) :
    JsSyntax("return${if (value != null) " $value" else ""}")