package net.asere.kthot.js.dsl.dom

import net.asere.kthot.js.dsl.KthotCore
import net.asere.kthot.js.dsl.dom.type.data.array.JsDomArray
import net.asere.kthot.js.dsl.dom.type.data.array.syntax
import net.asere.kthot.js.dsl.dom.type.content.document.JsDocument
import net.asere.kthot.js.dsl.dom.type.content.document.syntax
import net.asere.kthot.js.dsl.dom.type.structure.form.JsForm
import net.asere.kthot.js.dsl.dom.type.structure.form.button.JsButton
import net.asere.kthot.js.dsl.dom.type.structure.form.button.syntax
import net.asere.kthot.js.dsl.dom.type.structure.form.syntax
import net.asere.kthot.js.dsl.dom.type.structure.form.validity.JsValidityState
import net.asere.kthot.js.dsl.dom.type.structure.form.validity.syntax
import net.asere.kthot.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kthot.js.dsl.dom.type.data.obj.syntax
import net.asere.kthot.js.dsl.dom.type.structure.div.JsDiv
import net.asere.kthot.js.dsl.dom.type.structure.div.syntax
import net.asere.kthot.js.dsl.dom.type.structure.paragraph.JsParagraph
import net.asere.kthot.js.dsl.dom.type.structure.paragraph.syntax
import net.asere.kthot.js.dsl.dom.type.window.screen.JsScreen
import net.asere.kthot.js.dsl.dom.type.window.screen.syntax
import net.asere.kthot.js.dsl.provider.register

open class KthotDom : KthotCore() {
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
        fun initialize() = object : KthotDom() {}.initialize()
    }
}