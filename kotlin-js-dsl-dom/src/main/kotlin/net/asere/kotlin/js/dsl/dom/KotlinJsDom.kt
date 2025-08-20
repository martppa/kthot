package net.asere.kotlin.js.dsl.dom

import net.asere.kotlin.js.dsl.JsDsl
import net.asere.kotlin.js.dsl.dom.type.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.array.syntax
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.dom.type.document.syntax
import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.obj.syntax
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.dom.type.screen.syntax
import net.asere.kotlin.js.dsl.provider.register

object KotlinJsDom : JsDsl {
    override fun initialize() {
        register(builder = JsDomObject::syntax)
        register(builder = JsScreen::syntax)
        register(builder = JsDomArray::syntax)
        register(builder = JsDocument::syntax)
    }
}