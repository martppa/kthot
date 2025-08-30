package net.asere.kotlin.js.dsl.ksp.annotation

/**
 * Annotation to mark a Kotlin class for which an interface should be generated.
 * The generated interface will represent a JavaScript type class and will include all public properties and functions
 * of the annotated class.
 *
 * @param name The desired name of the generated interface. If not provided,
 * the interface name will be derived from the class name with a "Js" prefix (e.g., "MyClass" -> "JsMyClass").
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class JsClass(val name: String = "")