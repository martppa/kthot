package net.asere.kthot.js.dsl.ksp.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class JsApiFunctionModule(val name: String = "")
