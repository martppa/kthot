package net.asere.kotlin.js.dsl.ksp.annotation

/**
 * Annotation to mark a Kotlin function for translation into a JavaScript method within a JsClass.
 * The JavaScript method body will be extracted from the DSL calls within this Kotlin function's body.
 * @param name The desired name of the JavaScript method. If not provided, the Kotlin function name will be used.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class JsMethod(val name: String = "")