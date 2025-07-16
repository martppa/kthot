package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement

fun jsReturn(element: JsElement) = JsSyntax("return $element")