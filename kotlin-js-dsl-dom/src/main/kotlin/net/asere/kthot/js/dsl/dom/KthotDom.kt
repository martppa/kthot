package net.asere.kthot.js.dsl.dom

import net.asere.kthot.js.dsl.KthotCore
import net.asere.kthot.js.dsl.dom.type.content.document.JsDocument
import net.asere.kthot.js.dsl.dom.type.content.document.syntax
import net.asere.kthot.js.dsl.dom.type.core.element.JsDomElement
import net.asere.kthot.js.dsl.dom.type.core.element.syntax
import net.asere.kthot.js.dsl.dom.type.core.event.target.JsEventTarget
import net.asere.kthot.js.dsl.dom.type.core.event.target.syntax
import net.asere.kthot.js.dsl.dom.type.core.node.JsNode
import net.asere.kthot.js.dsl.dom.type.core.node.list.JsNodeList
import net.asere.kthot.js.dsl.dom.type.core.node.list.syntax
import net.asere.kthot.js.dsl.dom.type.core.node.syntax
import net.asere.kthot.js.dsl.dom.type.html.anchor.JsAnchorElement
import net.asere.kthot.js.dsl.dom.type.html.anchor.syntax
import net.asere.kthot.js.dsl.dom.type.html.body.JsBodyElement
import net.asere.kthot.js.dsl.dom.type.html.body.syntax
import net.asere.kthot.js.dsl.dom.type.html.collection.JsHtmlCollection
import net.asere.kthot.js.dsl.dom.type.html.collection.syntax
import net.asere.kthot.js.dsl.dom.type.html.div.JsDivElement
import net.asere.kthot.js.dsl.dom.type.html.div.syntax
import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.dom.type.html.element.syntax
import net.asere.kthot.js.dsl.dom.type.html.form.JsFormElement
import net.asere.kthot.js.dsl.dom.type.html.form.button.JsButtonElement
import net.asere.kthot.js.dsl.dom.type.html.form.button.syntax
import net.asere.kthot.js.dsl.dom.type.html.form.syntax
import net.asere.kthot.js.dsl.dom.type.html.form.validity.JsValidityState
import net.asere.kthot.js.dsl.dom.type.html.form.validity.syntax
import net.asere.kthot.js.dsl.dom.type.html.head.JsHeadElement
import net.asere.kthot.js.dsl.dom.type.html.head.syntax
import net.asere.kthot.js.dsl.dom.type.html.paragraph.JsParagraphElement
import net.asere.kthot.js.dsl.dom.type.html.paragraph.syntax
import net.asere.kthot.js.dsl.dom.type.window.screen.JsScreen
import net.asere.kthot.js.dsl.dom.type.window.screen.syntax
import net.asere.kthot.js.dsl.provider.register

open class KthotDom : KthotCore() {
    override fun initialize() {
        super.initialize()
        register(builder = JsEventTarget::syntax)
        register(builder = JsNode::syntax)
        register(builder = JsDomElement::syntax)
        register(builder = JsHtmlElement::syntax)
        register(builder = JsScreen::syntax)
        register(builder = JsHtmlCollection::syntax)
        register(builder = JsDocument::syntax)
        register(builder = JsButtonElement::syntax)
        register(builder = JsValidityState::syntax)
        register(builder = JsFormElement::syntax)
        register(builder = JsDivElement::syntax)
        register(builder = JsParagraphElement::syntax)
        register(builder = JsBodyElement::syntax)
        register(builder = JsHeadElement::syntax)
        register(builder = JsAnchorElement::syntax)
        register(builder = JsNodeList::syntax)
    }

    companion object {
        fun initialize() = object : KthotDom() {}.initialize()
    }
}