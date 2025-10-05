package net.asere.kthot.js.dsl.dom.type.structure.form.validity

import net.asere.kthot.js.dsl.dom.type.data.obj.JsDomObject
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax

/**
 * Represents the JavaScript `ValidityState` object, which reports the validity of a form control's value against its constraints.
 * All properties are read-only boolean values.
 */
interface JsValidityState : JsDomObject {

    /**
     * True if the element's value is valid against all constraints.
     * Corresponds to `validityState.valid` in JavaScript.
     */
    val valid: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "valid"))

    /**
     * True if the element's value does not match the specified pattern.
     * Corresponds to `validityState.patternMismatch` in JavaScript.
     */
    val patternMismatch: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "patternMismatch"))

    /**
     * True if the element's value is an invalid email address.
     * Corresponds to `validityState.typeMismatch` in JavaScript (for 'email' type).
     */
    val typeMismatch: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "typeMismatch"))

    /**
     * True if the value exceeds the `max` attribute.
     * Corresponds to `validityState.rangeOverflow` in JavaScript.
     */
    val rangeOverflow: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "rangeOverflow"))

    /**
     * True if the value is less than the `min` attribute.
     * Corresponds to `validityState.rangeUnderflow` in JavaScript.
     */
    val rangeUnderflow: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "rangeUnderflow"))

    /**
     * True if the value does not match the `step` attribute.
     * Corresponds to `validityState.stepMismatch` in JavaScript.
     */
    val stepMismatch: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "stepMismatch"))

    /**
     * True if the value is empty but the `required` attribute is set.
     * Corresponds to `validityState.valueMissing` in JavaScript.
     */
    val valueMissing: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "valueMissing"))

    /**
     * True if the value is too short based on the `minlength` attribute.
     * Corresponds to `validityState.tooShort` in JavaScript.
     */
    val tooShort: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "tooShort"))

    /**
     * True if the value is too long based on the `maxlength` attribute.
     * Corresponds to `validityState.tooLong` in JavaScript.
     */
    val tooLong: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "tooLong"))

    /**
     * True if the element has custom validity that has been set to false by `setCustomValidity()`.
     * Corresponds to `validityState.customError` in JavaScript.
     */
    val customError: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "customError"))

    companion object
}