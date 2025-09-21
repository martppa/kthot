package net.asere.kotlin.js.dsl.dom.type.form.button

import net.asere.kotlin.js.dsl.JsNothing
import net.asere.kotlin.js.dsl.dom.type.event.dom.JsDomEvent
import net.asere.kotlin.js.dsl.dom.type.event.dom.def
import net.asere.kotlin.js.dsl.dom.type.form.JsForm
import net.asere.kotlin.js.dsl.dom.type.form.syntax
import net.asere.kotlin.js.dsl.dom.type.form.validity.JsValidityState
import net.asere.kotlin.js.dsl.dom.type.form.validity.syntax
import net.asere.kotlin.js.dsl.dom.type.obj.JsDomObject
import net.asere.kotlin.js.dsl.syntax
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.lambda.jsLambda
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.string.syntax

interface JsButton : JsDomObject {
    /**
     * Value of the button.
     * Corresponds to `button.value` in JavaScript.
     */
    val _value: JsString get() = JsString.syntax(ChainOperation(this, "value"))

    /**
     * Type of the button (e.g., "submit", "reset", "button", "menu").
     * Corresponds to `button.type` in JavaScript.
     */
    val type: JsString get() = JsString.syntax(ChainOperation(this, "type"))

    /**
     * The name of the button.
     * Corresponds to `button.name` in JavaScript.
     */
    val _name: JsString get() = JsString.syntax(ChainOperation(this, "name"))

    /**
     * Boolean value indicating if the button is disabled.
     * Corresponds to `button.disabled` in JavaScript.
     */
    val disabled: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "disabled"))

    /**
     * Gets a reference to the form the button belongs to, or null if it's not in a form.
     * Corresponds to `button.form` in JavaScript.
     */
    val form: JsForm get() = JsForm.syntax(ChainOperation(this, "form"))

    /**
     * The `formAction` attribute, which specifies where to send the form data.
     * Corresponds to `button.formAction` in JavaScript.
     */
    val formAction: JsString get() = JsString.syntax(ChainOperation(this, "formAction"))

    /**
     * Gets the `formEnctype` attribute, which specifies how the form data should be encoded.
     * Corresponds to `button.formEnctype` in JavaScript.
     */
    val formEnctype: JsString get() = JsString.syntax(ChainOperation(this, "formEnctype"))

    /**
     * The `formMethod` attribute, which specifies the HTTP method to use when submitting the form.
     * Corresponds to `button.formMethod` in JavaScript.
     */
    val formMethod: JsString get() = JsString.syntax(ChainOperation(this, "formMethod"))

    /**
     * Gets the `formNoValidate` attribute, which specifies that the form should not be validated upon submission.
     * Corresponds to `button.formNoValidate` in JavaScript.
     */
    val formNoValidate: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, "formNoValidate"))

    /**
     * Gets the `formTarget` attribute, which specifies where to display the response after submitting the form.
     * Corresponds to `button.formTarget` in JavaScript.
     */
    val formTarget: JsString get() = JsString.syntax(ChainOperation(this, "formTarget"))

    /**
     * Gets and sets the action to be performed ("hide", "show", or "toggle") on a popover element being
     * controlled by a control button. It reflects the value of the popovertargetaction HTML attribute.
     */
    val popoverTargetAction: JsString
        get() = JsString.syntax(
            ChainOperation(
                this,
                InvocationOperation("popoverTargetAction")
            )
        )

    /**
     * Gets and sets the popover element to control via a button. The JavaScript equivalent of the popovertarget HTML attribute.
     */
    val popoverTargetElement: JsString
        get() = JsString.syntax(
            ChainOperation(
                this,
                InvocationOperation("popoverTargetElement")
            )
        )

    /**
     * A boolean value indicating whether the button is a candidate for constraint validation. It is false if any
     * conditions bar it from constraint validation, including: its type property is reset or button; it has
     * a <datalist> ancestor; or the disabled property is set to true.
     */
    val willValidate: JsBoolean get() = JsBoolean.syntax(ChainOperation(this, InvocationOperation("willValidate")))

    /**
     * A string representing the localized message that describes the validation constraints that the control
     * does not satisfy (if any). This attribute is the empty string if the control is not a candidate for
     * constraint validation (willValidate is false), or it satisfies its constraints.
     */
    val validationMessage: JsBoolean
        get() = JsBoolean.syntax(
            ChainOperation(
                this,
                InvocationOperation("validationMessage")
            )
        )

    /**
     * A [JsValidityState] representing the validity states that this button is in.
     */
    val validity: JsValidityState get() = JsValidityState.syntax(ChainOperation(this, InvocationOperation("validity")))

    /**
     * Returns true if the element's value has no validity problems; otherwise, returns false.
     */
    fun checkValidity(): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("checkValidity")))

    /**
     * Performs the same action as checkValidity(), but also reports the result to the user if the invalid event was not canceled.
     */
    fun reportValidity(): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("reportValidity")))

    /**
     * Sets the custom validity message for the element. Use the empty string to indicate that the element does not
     * have a custom validity error.
     */
    fun setCustomValidity(message: JsString): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("reportValidity", message)))

    fun setOnClick(handler: JsLambda1<JsDomEvent>): JsNothing = JsNothing.syntax(
        value = this.addEventListener(
            event = JsDomEvent.EVENT_CLICK,
            handler = handler
        )
    )

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