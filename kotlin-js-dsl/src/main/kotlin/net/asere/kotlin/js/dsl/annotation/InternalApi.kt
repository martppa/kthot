package net.asere.kotlin.js.dsl.annotation

@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "This is an internal API for the library and should not be used in external code.")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR)
annotation class InternalApi