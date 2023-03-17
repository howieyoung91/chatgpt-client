/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */
package com.github.howieyoung91.chatgpt.client.chat

import com.github.howieyoung91.chatgpt.client.completion.Usage
import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/16 12:28
 */
data class ChatCompletionResponse(
    var id: String = "",
    var `object`: String = "",
    var created: Int = -1,
    var model: String = "",
    var choices: Array<ChatChoice> = emptyArray(),
    var usage: Usage = Usage(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatCompletionResponse

        if (id != other.id) return false
        if (`object` != other.`object`) return false
        if (created != other.created) return false
        if (model != other.model) return false
        if (!choices.contentEquals(other.choices)) return false
        if (usage != other.usage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + `object`.hashCode()
        result = 31 * result + created
        result = 31 * result + model.hashCode()
        result = 31 * result + choices.contentHashCode()
        result = 31 * result + usage.hashCode()
        return result
    }
}

data class ChatChoice(
    var index: Int = -1,
    var text: String = "",
    val message: Message? = null, // only exist if the `stream` in request params is `false`
    val delta: Message? = null,   // only exist if the `stream` in request params is `true`
    @Json(name = "finish_reason")
    var finishReason: String = "",
)