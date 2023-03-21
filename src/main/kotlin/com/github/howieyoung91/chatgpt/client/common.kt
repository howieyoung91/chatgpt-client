/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client

import com.squareup.moshi.Json

data class Choice(
    var text: String = "",
    var index: Int = -1,
    var logprobs: Int? = null,
    @Json(name = "finish_reason")
    var finishReason: String = "",
)

data class Usage(
    @Json(name = "prompt_tokens")
    var promptTokens: Int? = null,
    @Json(name = "completion_tokens")
    var completionTokens: Int? = null,
    @Json(name = "total_tokens")
    var totalTokens: Int? = null,
)