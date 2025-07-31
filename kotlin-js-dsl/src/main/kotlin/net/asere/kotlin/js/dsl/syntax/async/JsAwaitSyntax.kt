package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsAwaitSyntax<T : JsValue>(value: JsPromise<T>) : JsSyntax("await $value")