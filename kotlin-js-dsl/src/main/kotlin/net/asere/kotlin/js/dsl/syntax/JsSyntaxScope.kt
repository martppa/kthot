package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.annotation.JsInternalApi
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.obj.JsObjectRef
import net.asere.kotlin.js.dsl.type.reference.JsReference

open class JsSyntaxScope : JsScope(), JsElement {

    @OptIn(JsInternalApi::class)
    private val syntaxBuilder: JsSyntaxBuilder<JsReference<*>> = JsSyntaxBuilder(JsObjectRef())

    override fun append(syntax: JsSyntax) {
        syntaxBuilder.append(syntax)
    }

    override fun present(): String = syntaxBuilder.present()

    override fun toString(): String = present()

    fun forceSingleLine() = syntaxBuilder.forceSingleLine()
}

fun <T : JsElement> JsSyntaxScope.run(block: JsSyntaxScope.() -> T) = block(this)