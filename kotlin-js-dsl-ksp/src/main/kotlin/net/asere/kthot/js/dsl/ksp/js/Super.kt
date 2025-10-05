package net.asere.kthot.js.dsl.ksp.js

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.JsElement

@JsDsl
fun JsConstructorScope.Super(vararg jsElements: JsElement) = +JsSyntax("super(${jsElements.joinToString(", ")})")