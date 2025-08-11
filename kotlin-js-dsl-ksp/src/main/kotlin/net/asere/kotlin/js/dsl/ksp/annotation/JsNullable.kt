package net.asere.kotlin.js.dsl.ksp.annotation

/**
 * Marks a property or function as having a nullable return type in the generated JavaScript code.
 *
 * This annotation is used by the DSL's symbol processor to determine when to use null-safe
 * operators in the generated JavaScript code. It is essential for correctly handling
 * potentially `null` or `undefined` values from JavaScript APIs.
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class JsNullable()