package net.asere.kotlin.js.dsl.types.type

import net.asere.kotlin.js.dsl.syntax.value.JsObjectSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl

/**
 * Represents the JavaScript `undefined` primitive value.
 * This is a DSL extension object, allowing you to use `undefined` directly in your JavaScript DSL code.
 *
 * In JavaScript, `undefined` is a primitive value automatically assigned to variables that have just been declared,
 * or to formal arguments for which there are no actual arguments.
 */
@JsDsl
object undefined : JsObjectSyntax("undefined")