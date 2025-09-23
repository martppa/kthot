package net.asere.kotlin.js.dsl.dom

import net.asere.kotlin.js.dsl.KotlinJslCore
import net.asere.kotlin.js.dsl.dom.type.data.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.data.array.syntax
import net.asere.kotlin.js.dsl.dom.type.content.document.JsDocument
import net.asere.kotlin.js.dsl.dom.type.content.document.syntax
import net.asere.kotlin.js.dsl.dom.type.structure.form.JsForm
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.JsButton
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.syntax
import net.asere.kotlin.js.dsl.dom.type.structure.form.syntax
import net.asere.kotlin.js.dsl.dom.type.structure.form.validity.JsValidityState
import net.asere.kotlin.js.dsl.dom.type.structure.form.validity.syntax
import net.asere.kotlin.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.data.obj.syntax
import net.asere.kotlin.js.dsl.dom.type.structure.div.JsDiv
import net.asere.kotlin.js.dsl.dom.type.structure.div.syntax
import net.asere.kotlin.js.dsl.dom.type.structure.paragraph.JsParagraph
import net.asere.kotlin.js.dsl.dom.type.structure.paragraph.syntax
import net.asere.kotlin.js.dsl.dom.type.window.screen.JsScreen
import net.asere.kotlin.js.dsl.dom.type.window.screen.syntax
import net.asere.kotlin.js.dsl.provider.register

open class KotlinJslDom : KotlinJslCore() {
    override fun initialize() {
        super.initialize()
        register(builder = JsDomObject::syntax)
        register(builder = JsScreen::syntax)
        register(builder = JsDomArray::syntax)
        register(builder = JsDocument::syntax)
        register(builder = JsButton::syntax)
        register(builder = JsValidityState::syntax)
        register(builder = JsForm::syntax)
        register(builder = JsDiv::syntax)
        register(builder = JsParagraph::syntax)
    }

    companion object {
        fun initialize() = object : KotlinJslDom() {}.initialize()
    }
}