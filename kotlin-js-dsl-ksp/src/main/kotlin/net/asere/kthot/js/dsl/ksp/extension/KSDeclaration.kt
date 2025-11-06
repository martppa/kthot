package net.asere.kthot.js.dsl.ksp.extension

import com.google.devtools.ksp.closestClassDeclaration
import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.*
import net.asere.kthot.js.dsl.ksp.processor.jsElementName

/**
 * Removes the helper suffix. Any value ending on "Ref", "Syntax" or "Value" will be removed.
 */
internal fun String.stripHelperSuffix(): String = this.let {
    when {
        it.endsWith("Ref") -> it.dropLast(3)
        it.endsWith("Syntax") && !it.endsWith("JsSyntax") -> it.dropLast(6)
        it.endsWith("Value") && it.endsWith("JsValue") -> it.dropLast(5)
        else -> it
    }
}

/**
 * Package + basic type. Basic type is the basic type of helper. Helpers are references, syntax or values.
 * For example, JsNumberRef is the reference helper of JsNumber.
 */
val KSDeclaration.fullBasicTypeName: String get() = qualifiedName?.asString()?.stripHelperSuffix() ?: "Any"

/**
 * Package + declaration name
 */
val KSDeclaration.fullName: String get() = qualifiedName?.asString() ?: "Any"

/**
 * Package + javascript declaration name declared in class definition
 */
val KSDeclaration.fullJsName: String get() = "${packageName.asString()}.${jsName}"

/**
 * Simple name of the declaration
 */
val KSDeclaration.name: String get() = simpleName.asString()

/**
 * Simple basic type. Basic type is the base type of helper.
 * For example, JsNumberRef is the reference helper of JsNumber.
 */
val KSDeclaration.basicTypeName: String get() = simpleName.asString().stripHelperSuffix()

/**
 * Returns whether a declaration is a JsElement or not.
 */
fun KSDeclaration?.isJsElement(resolver: Resolver): Boolean {
    val jsElement = resolver.loadClass(jsElementName)
    return this.isSubclassOf(jsElement)
}

/**
 * Returns whether a declaration is a subclass of the parameter or not.
 */
fun KSDeclaration?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.closestClassDeclaration()
    ?.isSubclassOf(classDeclaration)
    ?: false

/**
 * Returns whether the declaration is a non-null Any or not
 */
fun KSDeclaration.isAny() = qualifiedName?.asString() == "kotlin.Any"

/**
 * Returns a list of publicly exposed generic types
 */
fun KSDeclaration.getGenericReturnTypes(resolver: Resolver): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf()
    fun checkArguments(argument: KSTypeArgument) {
        if (argument.type?.isGenericTypeParameter() ?: false) {
            argument.type?.let { type -> types.add(type.resolve()) }
        }
        argument.type?.resolve()?.arguments?.map {
            it.type?.resolve()?.let { type -> types.add(type) }
            checkArguments(it)
        }
    }
    if (this is KSClassDeclaration) {
        getAllProperties().filter {
            (it.getVisibility() == Visibility.PUBLIC && it.isJsElement(resolver)) || it.type.isGenericTypeParameter()
        }.forEach { property ->
            if (property.type.isGenericTypeParameter()) {
                types.add(property.type.resolve())
            } else {
                property.type.resolve().arguments.map {
                    checkArguments(it)
                }

            }
        }
        declarations.filterIsInstance<KSFunctionDeclaration>()
            .filter { it.getVisibility() == Visibility.PUBLIC }
            .filter { !it.isConstructor() }
            .filter {
                it.returnType?.resolve()?.declaration.isJsElement(resolver) || it.returnType.isGenericTypeParameter()
            }.forEach { function ->
                if (function.returnType.isGenericTypeParameter()) {
                    function.returnType?.resolve()?.let { types.add(it) }
                } else {
                    val generics = function.returnType?.resolve()?.arguments?.map {
                        it.type?.resolve()?.let { type -> types.add(type) }
                        checkArguments(it)
                    } ?: listOf()
                    if (generics.isNotEmpty()) {
                        function.returnType?.resolve()?.let { types.add(it) }
                    }
                }
            }
    }
    if (this is KSPropertyDeclaration) {
        types.addAll(type.resolve().declaration.getGenericReturnTypes(resolver))
    }
    println("$jsName -> $types")
    return types
}

/**
 * The name provided to annotation at declaration
 */
val KSDeclaration.jsName: String get() {
    if (this is KSClassDeclaration) return jsName
    return name
}

/**
 * The name of its basic type. For example, JsNumberRef -> JsNumber
 */
val KSDeclaration.basicJsName: String get() = name.stripHelperSuffix()

/**
 * Returns the generic types names as string, For example,
 * <T, C, X>
 */
val KSDeclaration.genericTypesNamesString: String get() {
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        genericTypes.add(parameter.jsName)
    }
    if (genericTypes.isEmpty()) return ""
    return "<${genericTypes.joinToString()}>"
}

/**
 * Replace all generic types with a string and returns the definition syntax as string. For example,
 * for generic class Foo<String, Number>, if you provide "JsValue" it will return "<JsValue, JsValue>". If none
 * is found, it will return an empty string.
 */
fun KSDeclaration.buildGenericTypesAsString(value: String): String {
    val genericTypes = mutableListOf<String>()
    typeParameters.forEach { parameter ->
        genericTypes.add(value)
    }
    if (genericTypes.isEmpty()) return ""
    return "<${genericTypes.joinToString()}>"
}

/**
 * Returns all generic types of the declaration as JsValue in a string format. For example, for
 * Foo<String, Number> it will literally return <JsValue, JsValue> string. If none is found, returns an empty string.
 */
val KSDeclaration.genericTypesAsJsValueString: String get() = buildGenericTypesAsString("JsValue")

/**
 * Returns all generic types of the declaration as * in a string format. For example, for
 * Foo<String, Number> it will literally return <*, *> string. If none is found, it returns an empty string.
 */
val KSDeclaration.genericTypesAsStarString: String get() = buildGenericTypesAsString("*")

/**
 * Collects all KSTypes associated with a given KSDeclaration, including
 * its type parameters and their bounds.
 *
 * @return A set of all unique KSTypes found in the declaration's type hierarchy.
 */
fun KSDeclaration.getAllTypes(): Set<KSType> {
    val types = mutableSetOf<KSType>()

    if (this is KSPropertyDeclaration) {
        val typeReference = this.type
        typeReference.collectTypesRecursively( types)
    }

    typeParameters.forEach { parameter ->
        parameter.bounds.forEach { bound ->
            bound.collectTypesRecursively(types)
        }
    }

    return types
}

val KSDeclaration.isImportable: Boolean get() = this is KSClassDeclaration && this.isImportable