package net.asere.kthot.js.dsl.dom.type.html.form.button

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kthot.js.dsl.dom.type.data.event.dom.def
import net.asere.kthot.js.dsl.dom.type.html.element.JsHtmlElement
import net.asere.kthot.js.dsl.dom.type.html.form.JsFormElement
import net.asere.kthot.js.dsl.dom.type.html.form.syntax
import net.asere.kthot.js.dsl.dom.type.html.form.validity.JsValidityState
import net.asere.kthot.js.dsl.dom.type.html.form.validity.syntax
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.JsScope
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.JsBooleanRef
import net.asere.kthot.js.dsl.type.bool.ref
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.lambda.jsLambda
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.js
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `HTMLButtonElement`, providing access to the properties and methods of an HTML `<button>` element.
 * It extends the base [JsHtmlElement].
 */
interface JsButtonElement : JsHtmlElement {

    /**
     * Gets or sets the `value` attribute of the button.
     * Corresponds to `button.value` in JavaScript.
     */
    val _value: JsStringRef
        get() = JsString.ref(ChainOperation(this, "value"))

    /**
     * Gets or sets the `type` of the button (e.g., "submit", "reset", "button").
     * Corresponds to `button.type` in JavaScript.
     */
    val type: JsStringRef
        get() = JsString.ref(ChainOperation(this, "type"))

    /**
     * Gets or sets the `name` attribute of the button.
     * Corresponds to `button.name` in JavaScript.
     */
    val _name: JsStringRef
        get() = JsString.ref(ChainOperation(this, "name"))

    /**
     * Gets or sets a boolean value indicating if the button is disabled.
     * Corresponds to `button.disabled` in JavaScript.
     */
    val disabled: JsBooleanRef
        get() = JsBoolean.ref(ChainOperation(this, "disabled"))

    /**
     * Gets a read-only reference to the form the button belongs to, or null if it's not in a form.
     * Corresponds to `button.form` in JavaScript.
     */
    val form: JsFormElement
        get() = JsFormElement.syntax(ChainOperation(this, "form"))

    /**
     * Gets or sets the `formAction` attribute, which specifies where to send the form data, overriding the form's action.
     * Corresponds to `button.formAction` in JavaScript.
     */
    val formAction: JsStringRef
        get() = JsString.ref(ChainOperation(this, "formAction"))

    /**
     * Gets or sets the `formEnctype` attribute, which specifies how the form data should be encoded.
     * Corresponds to `button.formEnctype` in JavaScript.
     */
    val formEnctype: JsStringRef
        get() = JsString.ref(ChainOperation(this, "formEnctype"))

    /**
     * Gets or sets the `formMethod` attribute, which specifies the HTTP method to use.
     * Corresponds to `button.formMethod` in JavaScript.
     */
    val formMethod: JsStringRef
        get() = JsString.ref(ChainOperation(this, "formMethod"))

    /**
     * Gets or sets the `formNoValidate` attribute, which prevents form validation upon submission.
     * Corresponds to `button.formNoValidate` in JavaScript.
     */
    val formNoValidate: JsBooleanRef
        get() = JsBoolean.ref(ChainOperation(this, "formNoValidate"))

    /**
     * Gets or sets the `formTarget` attribute, which specifies where to display the response.
     * Corresponds to `button.formTarget` in JavaScript.
     */
    val formTarget: JsStringRef
        get() = JsString.ref(ChainOperation(this, "formTarget"))

    /**
     * Gets or sets the action ("hide", "show", or "toggle") on a controlled popover element.
     * Corresponds to `button.popoverTargetAction`.
     */
    val popoverTargetAction: JsStringRef
        get() = JsString.ref(ChainOperation(this, "popoverTargetAction"))

    /**
     * Gets or sets the ID of the popover element to control.
     * Corresponds to `button.popoverTargetElement`.
     */
    val popoverTargetElement: JsStringRef
        get() = JsString.ref(ChainOperation(this, "popoverTargetElement"))

    /**
     * A boolean value indicating whether the button is a candidate for constraint validation.
     * Corresponds to `button.willValidate`.
     */
    val willValidate: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "willValidate")) // Corrected: Removed InvocationOperation

    /**
     * A string representing the localized message that describes the validation constraints that the control does not satisfy.
     * Corresponds to `button.validationMessage`.
     */
    val validationMessage: JsString
        get() = JsString.syntax(ChainOperation(this, "validationMessage"))

    /**
     * A [JsValidityState] representing the validity states that this button is in.
     * Corresponds to `button.validity`.
     */
    val validity: JsValidityState get() = JsValidityState.syntax(ChainOperation(this, "validity"))

    /**
     * Returns true if the element's value has no validity problems; otherwise, returns false.
     * Corresponds to `button.checkValidity()`.
     */
    fun checkValidity(): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("checkValidity")))

    /**
     * Performs the same action as checkValidity(), but also reports the result to the user if invalid.
     * Corresponds to `button.reportValidity()`.
     */
    fun reportValidity(): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("reportValidity")))

    /**
     * Sets the custom validity message for the element.
     * Corresponds to `button.setCustomValidity(message)`.
     */
    fun setCustomValidity(message: JsString): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("setCustomValidity", message))) // Corrected method name in InvocationOperation

    fun setCustomValidity(message: String): JsNothing = setCustomValidity(message.js)

    /**
     * Assigns a standard Kthot [JsLambda1] handler to the `click` event.
     */
    fun setOnClick(handler: JsLambda1<JsDomEvent>): JsNothing = JsNothing.syntax(
        value = this.addEventListener(
            event = JsDomEvent.EVENT_CLICK,
            handler = handler
        )
    )

    /**
     * Assigns an idiomatic Kotlin lambda handler to the `click` event.
     */
    fun setOnClick(handler: JsScope.(JsDomEvent) -> Unit): JsNothing {
        val scope = JsSyntaxScope()
        val event = JsDomEvent.def("event")
        handler(scope, event.reference)
        val lambda = jsLambda(param1 = event) {
            +scope
        }
        return JsNothing.syntax(
            value = this.addEventListener(
                event = JsDomEvent.EVENT_CLICK,
                handler = lambda
            )
        )
    }

    companion object {
        val TARGET_ACTION_HIDE: JsString = "hide".js
        val TARGET_ACTION_SHOW: JsString = "show".js
        val TARGET_ACTION_TOGGLE: JsString = "toggle".js
        val BUTTON_TYPE: JsString = "button".js
        val SUBMIT_TYPE: JsString = "submit".js
        val RESET_TYPE: JsString = "reset".js
        val MENU_TYPE: JsString = "menu".js
    }
}