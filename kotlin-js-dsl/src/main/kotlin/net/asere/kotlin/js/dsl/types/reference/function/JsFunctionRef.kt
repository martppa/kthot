package net.asere.kotlin.js.dsl.types.reference.function

import net.asere.kotlin.js.dsl.syntax.JsSyntax

class JsFunctionRef(
    name: String? = null,
) : JsFunctionRefCommons(name) {
    operator fun invoke() = JsSyntax("$this()")
}
