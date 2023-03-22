/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client.completion

import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/12 14:13
 */
data class CompletionRequest(
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

    @Json(name = "logit_bias")
    var logitBias: Map<*, *>? = null
    var user: String? = null

    enum class Model(val modelName: String) {
        TEXT_DAVINCI_003("text-davinci-003"), // default
        BABBAGE("babbage"),
        DAVINCI("davinci"),
        TEXT_DAVINCI_001("text-davinci-001"),
        ADA("ada"),
        CURIE_INSTRUCT_BETA("curie-instruct-beta"),
        CODE_CUSHMAN_001("code-cushman-001"),
        TEXT_ADA_001("text-ada-001"),
        TEXT_CURIE_001("text-curie-001"),
        DAVINCI_INSTRUCT_BETA("davinci-instruct-beta"),
        TEXT_DAVINCI_002("text-davinci-002"),
        TEXT_BABBAGE_001("text-babbage-001"),
        CODE_DAVINCI_002("code-davinci-002"),
        CURIE("curie");


        companion object {
            val NAMES = arrayOf(
                "text-davinci-003", // default
                "babbage", "davinci", "text-davinci-001", "ada", "curie-instruct-beta", "code-cushman-001",
                "text-ada-001", "text-curie-001", "davinci-instruct-beta", "text-davinci-002",
                "text-babbage-001", "code-davinci-002", "curie"
            )
        }
    }
}