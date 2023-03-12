package com.github.howieyoung91.chatgpt.client.completion

import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/12 14:13
 */
open class CompletionRequest(
    var model: String = "",
    var prompt: String = "",
) {
    var suffix: String? = null

    @Json(name = "max_tokens")
    var maxTokens: Int? = null
    var temperature: Double? = null

    @Json(name = "top_p")
    var topP: Int? = null
    var n: Int? = null
    var stream: Boolean? = null
    var logprobs: Int? = null
    var echo: Boolean? = false
    var stop: String? = null

    @Json(name = "presence_penalty")
    var presencePenalty: Double? = null

    @Json(name = "frequency_penalty")
    var frequencyPenalty: Double? = null

    @Json(name = "best_of")
    var bestOf: Int? = null
    var logit_bias: Map<*, *>? = null
    var user: String? = null
}