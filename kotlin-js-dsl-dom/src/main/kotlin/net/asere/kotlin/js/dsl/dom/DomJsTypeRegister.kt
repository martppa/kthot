package net.asere.kotlin.js.dsl.dom

import net.asere.kotlin.js.dsl.BasicJsTypeRegister
import net.asere.kotlin.js.dsl.dom.type.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.array.syntax
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.dom.type.document.syntax
import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.obj.syntax
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.dom.type.screen.syntax
import net.asere.kotlin.js.dsl.provider.register

open class DomJsTypeRegister : BasicJsTypeRegister() {
    override fun initialize() {
        super.initialize()
        register(builder = JsDomObject::syntax)
        register(builder = JsScreen::syntax)
        register(builder = JsDomArray::syntax)
        register(builder = JsDocument::syntax)
    }
}