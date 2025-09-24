package net.asere.kotlin.js.dsl.type.definition.validation

import java.util.regex.Pattern

/**
 * A comprehensive list of JavaScript reserved keywords that cannot be used as
 * variable names.
 */
private val RESERVED_KEYWORDS = setOf(
    "abstract", "arguments", "await", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
    "debugger", "default", "delete", "do", "double", "else", "enum", "eval", "export", "extends", "false", "final",
    "finally", "float", "for", "function", "goto", "if", "implements", "import", "in", "instanceof", "int", "interface",
    "let", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static",
    "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "typeof", "var", "void",
    "volatile", "while", "with", "yield"
)

/**
 * A regular expression to check if a string is a valid JavaScript variable name
 * in terms of its character composition.
 *
 * It checks for:
 * - A starting character that is a letter (a-z, A-Z), underscore (_), or dollar sign ($).
 * - Subsequent characters that can be letters, numbers (0-9), underscore, or dollar sign.
 *
 * NOTE: This regex does not check for reserved keywords.
 */
private val JS_IDENTIFIER_REGEX = Pattern.compile("^[a-zA-Z_\$][a-zA-Z0-9_\$]*\$")

/**
 * Validates a string to determine if it is a valid JavaScript variable name.
 *
 * This function performs a two-step check:
 * 1. It uses a regular expression to validate the character composition.
 * 2. It checks if the string is a JavaScript reserved keyword.
 *
 * @param name The string to validate.
 * @return True if the string is a valid variable name, false otherwise.
 */
internal fun isValidVariableName(name: String): Boolean {
    val matcher = JS_IDENTIFIER_REGEX.matcher(name)
    val isCharacterValid = matcher.matches()

    if (!isCharacterValid) {
        return false
    }

    val isReserved = RESERVED_KEYWORDS.contains(name)
    return !isReserved
}