package net.asere.kthot.js.dsl.dom.type.content.media.stream.constraint

import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.value
import net.asere.kthot.js.dsl.type.obj.JsObjectBuilder
import net.asere.kthot.js.dsl.type.value.JsValue

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

    fun build(): JsMediaStreamConstraint {
        val objectBuilder = JsObjectBuilder()
        video?.let { objectBuilder.property("video", it) }
        audio?.let { objectBuilder.property("audio", it) }
        return JsMediaStreamConstraint.syntax(objectBuilder.build())
    }
}

fun JsMediaStreamConstraint.Companion.build(
    block: JsMediaStreamConstraintsBuilder.() -> Unit
): JsMediaStreamConstraint =
    JsMediaStreamConstraintsBuilder().apply(block).build()