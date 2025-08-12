package net.asere.kotlin.js.dsl.syntax.async

import net.asere.kotlin.js.dsl.syntax.JsSyntax

class JsAwaitSyntax(value: JsAsyncCallable) : JsSyntax("await $value")