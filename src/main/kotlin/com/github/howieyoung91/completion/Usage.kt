package com.github.howieyoung91.completion

import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/12 02:36
 */
data class Usage(
    @Json(name = "prompt_tokens")
    var promptTokens: Int? = null,
    @Json(name = "completion_tokens")
    var completionTokens: Int? = null,
    @Json(name = "total_tokens")
    var totalTokens: Int? = null,
)