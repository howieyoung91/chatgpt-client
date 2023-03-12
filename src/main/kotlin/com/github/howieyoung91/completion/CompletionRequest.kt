package com.github.howieyoung91.completion

import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/12 02:01
 */
data class CompletionRequest(var model: String = "") {
    var prompt: String = ""
    var suffix: String? = null
    var maxTokens: Int? = null
    var temperature: Double? = null
    var topP: Int? = null
    var n: Int? = null
    var stream: Boolean? = null
    var logprobs: Int? = null
    var echo: Boolean? = false
    var stop: String? = null
    var presencePenalty: Double? = null
    var frequencyPenalty: Double? = null
    var bestOf: Int? = null
    var logit_bias: Map<*, *>? = null
    var user: String? = null

    constructor(model: String, prompt: String) : this(model) {
        this.prompt = prompt
    }
}

data class CompletionResponse(
    var id: String = "",
    var `object`: String = "",
    var created: Int = -1,
    var model: String = "",
    var choices: Array<Choice> = emptyArray(),
    var usage: Usage = Usage(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CompletionResponse

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

data class Choice(
    var text: String = "",
    var index: Int = -1,
    var logprobs: Int? = null,
    @Json(name = "finish_reason")
    var finishReason: String = "",
)
