package net.asere.kotlin.js.dsl.ksp.js

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement

@JsDsl
fun JsConstructorScope.Super(vararg jsElements: JsElement) = +JsSyntax("super(${jsElements.joinToString(", ")})")