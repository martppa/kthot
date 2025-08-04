package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration

fun Resolver.loadClass(className: String): KSClassDeclaration {
    val message = "class cannot be found. Have you included the dsl in your project dependencies?"
    return getClassDeclarationByName(
        name = getKSNameFromString(className)
    ) ?: throw IllegalStateException("$className $message")
}