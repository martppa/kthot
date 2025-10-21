package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import net.asere.kthot.js.dsl.ksp.processor.jsApiAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsApiFunctionClassAnnotationName
import net.asere.kthot.js.dsl.ksp.processor.jsClassAnnotationName

fun Resolver.classExist(className: String): Boolean = getClassDeclarationByName(
    name = getKSNameFromString(className)
) != null

fun Resolver.loadClass(className: String): KSClassDeclaration {
    val message = "class cannot be found. Have you included the dsl in your project dependencies?"
    return getClassDeclarationByName(
        name = getKSNameFromString(className)
    ) ?: throw IllegalStateException("$className $message")
}

fun Resolver.getClass(className: String): KSClassDeclaration? =
    getClassDeclarationByName(name = getKSNameFromString(className))

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

fun Resolver.findJsApiClasses(): Sequence<KSClassDeclaration> {
    val symbols = getSymbolsWithAnnotation(jsApiAnnotationName)
        .filterIsInstance<KSClassDeclaration>()
    return symbols
}

fun Resolver.findJsApiFunctionsClasses(): Sequence<KSClassDeclaration> {
    val symbols = getSymbolsWithAnnotation(jsApiFunctionClassAnnotationName)
        .filterIsInstance<KSClassDeclaration>()
    return symbols
}

fun Resolver.fileExists(fileName: String): Boolean = getAllFiles().find { it.fileName == fileName } != null