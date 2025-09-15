package net.asere.kotlin.js.dsl.syntax.group

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsElement

class JsGroupSyntax(element: JsElement) : JsSyntax("($element)")