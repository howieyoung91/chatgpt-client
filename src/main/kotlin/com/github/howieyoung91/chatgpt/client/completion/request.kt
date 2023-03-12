package com.github.howieyoung91.chatgpt.client.completion

/**
 * @author Howie Young
 * @date 2023/03/12 14:13
 */
open class CompletionRequest(
    var model: String = "",
    var prompt: String = "",
) {
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
}