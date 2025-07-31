package net.asere.kotlin.js.dsl.ksp.annotation

/**
 * Annotation to mark a Kotlin property for translation into a JavaScript property within a JsClass.
 * @param name The desired name of the JavaScript property. If not provided, the Kotlin property name will be used.
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class JsProperty(val name: String = "")