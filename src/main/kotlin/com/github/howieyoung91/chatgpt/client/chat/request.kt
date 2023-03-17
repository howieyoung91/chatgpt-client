/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client.chat

import com.squareup.moshi.Json


/**
 * Chat Completion Request
 *
 * some documentations:
 * 1. https://platform.openai.com/docs/api-reference/chat
 * 2. https://github.com/openai/openai-cookbook/blob/main/examples/How_to_stream_completions.ipynb
 *
 * @author Howie Young
 */
data class ChatCompletionRequest(
    var model: String = "",
    val messages: Array<out Message>,
) {

    var temperature: Double? = null

    @Json(name = "top_p")
    var topP: Int? = null
    var n: Int? = null
    var stream: Boolean? = null
    var stop: String? = null

    @Json(name = "max_tokens")
    var maxTokens: Int? = null

    @Json(name = "presence_penalty")
    var presencePenalty: Double? = null

    @Json(name = "frequency_penalty")
    var frequencyPenalty: Double? = null

    @Json(name = "logit_bias")
    var logitBias: Map<*, *>? = null
    var user: String? = null

    enum class Model(val modelName: String) {
        GPT_3_5_TURBO("gpt-3.5-turbo"),
        GPT_3_5_TURBO_0301("gpt-3.5-turbo-0301")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChatCompletionRequest

        if (model != other.model) return false
        if (!messages.contentEquals(other.messages)) return false
        if (maxTokens != other.maxTokens) return false
        if (temperature != other.temperature) return false
        if (topP != other.topP) return false
        if (n != other.n) return false
        if (stream != other.stream) return false
        if (stop != other.stop) return false
        if (presencePenalty != other.presencePenalty) return false
        if (frequencyPenalty != other.frequencyPenalty) return false
        if (logitBias != other.logitBias) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = model.hashCode()
        result = 31 * result + messages.contentHashCode()
        result = 31 * result + (maxTokens?.hashCode() ?: 0)
        result = 31 * result + (temperature?.hashCode() ?: 0)
        result = 31 * result + (topP?.hashCode() ?: 0)
        result = 31 * result + (n?.hashCode() ?: 0)
        result = 31 * result + (stream?.hashCode() ?: 0)
        result = 31 * result + (stop?.hashCode() ?: 0)
        result = 31 * result + (presencePenalty?.hashCode() ?: 0)
        result = 31 * result + (frequencyPenalty?.hashCode() ?: 0)
        result = 31 * result + (logitBias?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
        return result
    }
}

/**
 * @author Howie Young
 */
data class Message(private val role: String, private val content: String) {
    companion object {
        const val SYSTEM_ROLE = "system"
        const val USER_ROLE = "user"
        const val ASSISTANT_ROLE = "assistant"
    }
}