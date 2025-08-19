package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import net.asere.kotlin.js.dsl.ksp.processor.jsClassAnnotationName

fun Resolver.loadClass(className: String): KSClassDeclaration {
    val message = "class cannot be found. Have you included the dsl in your project dependencies?"
    return getClassDeclarationByName(
        name = getKSNameFromString(className)
    ) ?: throw IllegalStateException("$className $message")
}

fun Resolver.loadFunction(functionName: String): Sequence<KSFunctionDeclaration> {
    val message = "function cannot be found. Have you included the dsl in your project dependencies?"
    return getFunctionDeclarationsByName(
        name = getKSNameFromString(functionName)
    ).also {
        if (it.toList().isEmpty()) throw IllegalStateException("$functionName $message")
    }
}

fun Resolver.findJsClasses(): Sequence<KSClassDeclaration> {
    val symbols = getSymbolsWithAnnotation(jsClassAnnotationName)
        .filterIsInstance<KSClassDeclaration>()
    return symbols
}