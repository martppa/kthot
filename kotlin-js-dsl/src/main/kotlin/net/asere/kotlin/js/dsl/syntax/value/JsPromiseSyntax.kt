package net.asere.kotlin.js.dsl.syntax.value

import net.asere.kotlin.js.dsl.types.type.JsPromise
import net.asere.kotlin.js.dsl.types.value.JsValue

class JsPromiseSyntax<T : JsValue>(value: String) : JsReferenceSyntax<JsPromise<T>>(value), JsPromise<T>