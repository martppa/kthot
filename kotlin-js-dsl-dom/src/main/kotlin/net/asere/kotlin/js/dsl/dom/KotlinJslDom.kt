package net.asere.kotlin.js.dsl.dom

import net.asere.kotlin.js.dsl.KotlinJslCore
import net.asere.kotlin.js.dsl.dom.type.array.JsDomArray
import net.asere.kotlin.js.dsl.dom.type.array.syntax
import net.asere.kotlin.js.dsl.dom.type.document.JsDocument
import net.asere.kotlin.js.dsl.dom.type.document.syntax
import net.asere.kotlin.js.dsl.dom.type.form.JsForm
import net.asere.kotlin.js.dsl.dom.type.form.button.JsButton
import net.asere.kotlin.js.dsl.dom.type.form.button.syntax
import net.asere.kotlin.js.dsl.dom.type.form.syntax
import net.asere.kotlin.js.dsl.dom.type.form.validity.JsValidityState
import net.asere.kotlin.js.dsl.dom.type.form.validity.syntax
import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.dom.type.obj.syntax
import net.asere.kotlin.js.dsl.dom.type.screen.JsScreen
import net.asere.kotlin.js.dsl.dom.type.screen.syntax
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
    }

    companion object {
        fun initialize() = object : KotlinJslDom() {}.initialize()
    }
}