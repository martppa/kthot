package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.array.JsArray
import net.asere.kotlin.js.dsl.type.array.syntax
import net.asere.kotlin.js.dsl.type.value.JsValue
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.JsNumberSyntax
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.Undefined

/**
 * Represents a JavaScript string primitive value.
 * This interface extends [JsValue].
 */
interface JsString : JsValue {
    companion object

    /**
     * Returns the length of the string.
     *
     * In JavaScript, this corresponds to `string.length`.
     * @return A [net.asere.kotlin.js.dsl.type.number.JsNumber] object representing the length of the string.
     */
    fun getLength(): JsNumber = JsNumber.syntax(ChainOperation(this, "length"))

    /**
     * Returns the character at the specified index (position) in a string.
     *
     * In JavaScript, this corresponds to `string.charAt(index)`.
     * @param index The index of the character to retrieve as a [JsNumber] object.
     * @return A [JsString] object representing the character at the specified index.
     */
    fun charAt(index: JsNumber): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("charAt", index)))

    /**
     * Returns the Unicode of the character at the specified index in a string.
     *
     * In JavaScript, this corresponds to `string.charCodeAt(index)`.
     * @param index The index of the character to retrieve as a [JsNumber] object.
     * @return A [JsNumber] object representing the UTF-16 code unit value of the character at the specified index.
     */
    fun charCodeAt(index: JsNumber): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("charCodeAt", index)))

    /**
     * Joins two or more strings.
     *
     * In JavaScript, this corresponds to `string.concat(string1, string2, ...)`.
     * @param strings A variable number of [JsString] objects to concatenate.
     * @return A [JsString] object representing the new concatenated string.
     */
    fun concat(vararg strings: JsString): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("concat", *strings)))
    }

    /**
     * Checks whether a string ends with the characters of a specified string.
     *
     * In JavaScript, this corresponds to `string.endsWith(searchString, length)`.
     * @param searchString The characters to be searched for at the end of this string as a [JsString] object.
     * @param length An optional [JsNumber] indicating the length of the string to search within.
     * @return A [net.asere.kotlin.js.dsl.type.bool.JsBoolean] object indicating whether the string ends with the specified characters.
     */
    fun endsWith(searchString: JsString, length: JsNumber? = null): JsBoolean {
        return JsBoolean.syntax(ChainOperation(this, InvocationOperation("endsWith", searchString, length ?: Undefined)))
    }

    /**
     * Checks whether a string contains the characters of a specified string.
     *
     * In JavaScript, this corresponds to `string.includes(searchString, position)`.
     * @param searchString The characters to be searched for within this string as a [JsString] object.
     * @param position An optional [JsNumber] indicating the position at which to begin searching.
     * @return A [JsBoolean] object indicating whether the string contains the specified characters.
     */
    fun includes(searchString: JsString, position: JsNumber? = null): JsBoolean {
        return JsBoolean.syntax(
            ChainOperation(
                this,
                InvocationOperation("includes", searchString, position ?: Undefined)
            )
        )
    }

    /**
     * Returns the position of the first occurrence of a specified value in a string.
     *
     * In JavaScript, this corresponds to `string.indexOf(searchValue, fromIndex)`.
     * @param searchValue The value to search for as a [JsString] object.
     * @param fromIndex An optional [JsNumber] indicating the position at which to start the search.
     * @return A [JsNumber] object representing the index of the first occurrence, or -1 if not found.
     */
    fun indexOf(searchValue: JsString, fromIndex: JsNumber? = null): JsNumber {
        return JsNumberSyntax(ChainOperation(this, InvocationOperation("indexOf", searchValue, fromIndex ?: Undefined)))
    }

    /**
     * Returns the position of the last occurrence of a specified value in a string.
     *
     * In JavaScript, this corresponds to `string.lastIndexOf(searchValue, fromIndex)`.
     * @param searchValue The value to search for as a [JsString] object.
     * @param fromIndex An optional [JsNumber] indicating the position at which to start the search backward.
     * @return A [JsNumber] object representing the index of the last occurrence, or -1 if not found.
     */
    fun lastIndexOf(searchValue: JsString, fromIndex: JsNumber? = null): JsNumber {
        return JsNumberSyntax(
            ChainOperation(
                this,
                InvocationOperation("lastIndexOf", searchValue, fromIndex ?: Undefined)
            )
        )
    }

    /**
     * Pads the current string with a given string (repeated, if needed) so that the resulting string
     * reaches a given length. The padding is applied from the end (right) of the current string.
     *
     * In JavaScript, this corresponds to `string.padEnd(targetLength, padString)`.
     * @param targetLength The length of the resulting string once the current string has been padded as a [JsNumber] object.
     * @param padString An optional [JsString] to pad the current string with. Defaults to a space.
     * @return A [JsString] object representing the new string of the specified length with the pad string applied to the end.
     */
    fun padEnd(targetLength: JsNumber, padString: JsString? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("padEnd", targetLength, padString ?: Undefined)))
    }

    /**
     * Pads the current string with a given string (repeated, if needed) so that the resulting string
     * reaches a given length. The padding is applied from the start (left) of the current string.
     *
     * In JavaScript, this corresponds to `string.padStart(targetLength, padString)`.
     * @param targetLength The length of the resulting string once the current string has been padded as a [JsNumber] object.
     * @param padString An optional [JsString] to pad the current string with. Defaults to a space.
     * @return A [JsString] object representing the new string of the specified length with the pad string applied to the start.
     */
    fun padStart(targetLength: JsNumber, padString: JsString? = null): JsString {
        return JsString.syntax(
            ChainOperation(
                this,
                InvocationOperation("padStart", targetLength, padString ?: Undefined)
            )
        )
    }

    /**
     * Returns a new string with a specified number of copies of the string it was called on, concatenated together.
     *
     * In JavaScript, this corresponds to `string.repeat(count)`.
     * @param count The number of times to repeat the string as a [JsNumber] object.
     * @return A [JsString] object representing the new string with the repeated content.
     */
    fun repeat(count: JsNumber): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("repeat", count)))

    /**
     * Returns a new string with some or all matches of a `pattern` replaced by a `replacement`.
     * The `pattern` can be a string or a RegExp, and the `replacement` can be a string or a function.
     * This method only replaces the *first* occurrence if `searchValue` is a string.
     *
     * In JavaScript, this corresponds to `string.replace(searchValue, replaceValue)`.
     * @param searchValue The [JsString] to search for.
     * @param replaceValue The [JsString] to replace matches with.
     * @return A [JsString] object representing the new string with the replacement performed.
     */
    fun replace(searchValue: JsString, replaceValue: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("replace", searchValue, replaceValue)))

    /**
     * Returns a new string with all matches of a `pattern` replaced by a `replacement`.
     *
     * In JavaScript, this corresponds to `string.replaceAll(searchValue, replaceValue)`.
     * @param searchValue The [JsString] to search for.
     * @param replaceValue The [JsString] to replace matches with.
     * @return A [JsString] object representing the new string with all replacements performed.
     */
    fun replaceAll(searchValue: JsString, replaceValue: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("replaceAll", searchValue, replaceValue)))

    /**
     * Searches a string for a specified value, and returns the position of the match.
     *
     * In JavaScript, this corresponds to `string.search(regexp)`.
     * @param regexp A [JsString] representing a regular expression.
     * @return A [JsNumber] object representing the index of the first match, or -1 if no match is found.
     */
    fun search(regexp: JsString): JsNumber = JsNumber.syntax(ChainOperation(this, InvocationOperation("search", regexp)))

    /**
     * Extracts a section of a string and returns it as a new string.
     *
     * In JavaScript, this corresponds to `string.slice(startIndex, endIndex)`.
     * @param startIndex The index to start the slice (the first character is at index 0) as a [JsNumber] object.
     * @param endIndex An optional [JsNumber] indicating the end of the slice (up to, but not including, the character at this index).
     * @return A [JsString] object representing the extracted section of the string.
     */
    fun slice(startIndex: JsNumber, endIndex: JsNumber? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("slice", startIndex, endIndex ?: Undefined)))
    }

    /**
     * Splits a string into an array of substrings.
     *
     * In JavaScript, this corresponds to `string.split(separator, limit)`.
     * @param separator An optional [JsString] that indicates where each split should occur.
     * @param limit An optional [JsNumber] specifying a non-negative integer limiting the number of pieces to split the string into.
     * @return A [JsArray] of [JsString] objects representing the new array of substrings.
     */
    fun split(separator: JsString? = null, limit: JsNumber? = null): JsArray<JsString> {
        return JsArray.syntax(
            typeBuilder = JsString::syntax,
            value = ChainOperation(
                this,
                InvocationOperation("split", separator ?: Undefined, limit ?: Undefined)
            )
        )
    }

    /**
     * Checks whether a string begins with the characters of a specified string.
     *
     * In JavaScript, this corresponds to `string.startsWith(searchString, position)`.
     * @param searchString The characters to be searched for at the beginning of this string as a [JsString] object.
     * @param position An optional [JsNumber] indicating the position at which to begin searching.
     * @return A [JsBoolean] object indicating whether the string starts with the specified characters.
     */
    fun startsWith(searchString: JsString, position: JsNumber? = null): JsBoolean {
        return JsBoolean.syntax(
            ChainOperation(
                this,
                InvocationOperation("startsWith", searchString, position ?: Undefined)
            )
        )
    }

    /**
     * Extracts characters from `startIndex` up to (but not including) `endIndex` from a string.
     *
     * In JavaScript, this corresponds to `string.substring(startIndex, endIndex)`.
     * @param startIndex The index to start the substring (the first character is at index 0) as a [JsNumber] object.
     * @param endIndex An optional [JsNumber] indicating the end of the substring (up to, but not including, the character at this index).
     * @return A [JsString] object representing the extracted substring.
     */
    fun substring(startIndex: JsNumber, endIndex: JsNumber? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("substring", startIndex, endIndex ?: Undefined)))
    }

    /**
     * Converts a string to lowercase according to the host's current locale.
     * For most languages, this is the same as `toLowerCase()`.
     *
     * In JavaScript, this corresponds to `string.toLocaleLowerCase(locale)`.
     * @param locale An optional [JsValue] representing a BCP 47 language tag or an array of such tags.
     * @return A [JsString] object representing the new string converted to lowercase.
     */
    fun toLocaleLowerCase(locale: JsValue? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("toLocaleLowerCase", locale ?: Undefined)))
    }

    /**
     * Converts a string to uppercase according to the host's current locale.
     * For most languages, this is the same as `toUpperCase()`.
     *
     * In JavaScript, this corresponds to `string.toLocaleUpperCase(locale)`.
     * @param locale An optional [JsValue] representing a BCP 47 language tag or an array of such tags.
     * @return A [JsString] object representing the new string converted to uppercase.
     */
    fun toLocaleUpperCase(locale: JsValue? = null): JsString {
        return JsString.syntax(ChainOperation(this, InvocationOperation("toLocaleUpperCase", locale ?: Undefined)))
    }

    /**
     * Converts a string to lowercase.
     *
     * In JavaScript, this corresponds to `string.toLowerCase()`.
     * @return A [JsString] object representing the new string converted to lowercase.
     */
    fun toLowerCase(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("toLowerCase")))

    /**
     * Converts a string to uppercase.
     *
     * In JavaScript, this corresponds to `string.toUpperCase()`.
     * @return A [JsString] object representing the new string converted to uppercase.
     */
    fun toUpperCase(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("toUpperCase")))

    /**
     * Removes whitespace from both ends of a string.
     *
     * In JavaScript, this corresponds to `string.trim()`.
     * @return A [JsString] object representing the new string with whitespace removed from both ends.
     */
    fun trim(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("trim")))

    /**
     * Removes whitespace from the end (right) of a string.
     *
     * In JavaScript, this corresponds to `string.trimEnd()`.
     * @return A [JsString] object representing the new string with whitespace removed from the end.
     */
    fun trimEnd(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("trimEnd")))

    /**
     * Removes whitespace from the beginning (left) of a string.
     *
     * In JavaScript, this corresponds to `string.trimStart()`.
     * @return A [JsString] object representing the new string with whitespace removed from the beginning.
     */
    fun trimStart(): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("trimStart")))
}

/**
 * Extension property to convert a Kotlin [String] to a [JsString] instance.
 * This provides a convenient way to use Kotlin strings directly in JavaScript DSL.
 */
val String.js: JsString get() = JsString.value(this)