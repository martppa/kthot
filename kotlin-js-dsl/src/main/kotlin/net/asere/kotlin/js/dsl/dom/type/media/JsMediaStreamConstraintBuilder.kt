package net.asere.kotlin.js.dsl.dom.type.media

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.types.type.JsBoolean
import net.asere.kotlin.js.dsl.types.type.JsObject
import net.asere.kotlin.js.dsl.types.type.helper.JsObjectBuilder
import net.asere.kotlin.js.dsl.types.value.JsValue
import net.asere.kotlin.js.dsl.types.value.value

/**
 * Represents `MediaStreamConstraints` for `getUserMedia`.
 * This would be a builder or data class to create a JS object literal.
 */
class JsMediaStreamConstraintsBuilder {
    private var video: JsValue? = null
    private var audio: JsValue? = null

    fun video(enabled: Boolean = true, block: (JsObjectBuilder.() -> Unit)? = null) {
        video = if (block != null) JsObjectBuilder().apply(block).build() else JsBoolean.value(enabled)
    }

    fun audio(enabled: Boolean = true, block: (JsObjectBuilder.() -> Unit)? = null) {
        audio = if (block != null) JsObjectBuilder().apply(block).build() else JsBoolean.value(enabled)
    }

    fun build(): JsObject {
        val objectBuilder = JsObjectBuilder()
        video?.let { objectBuilder.property("video", it) }
        audio?.let { objectBuilder.property("audio", it) }
        return objectBuilder.build()
    }
}

fun mediaStreamConstraints(block: JsMediaStreamConstraintsBuilder.() -> Unit): JsObject =
    JsMediaStreamConstraintsBuilder().apply(block).build()