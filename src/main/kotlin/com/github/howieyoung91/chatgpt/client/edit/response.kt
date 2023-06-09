package com.github.howieyoung91.chatgpt.client.edit

import com.github.howieyoung91.chatgpt.client.Choice
import com.github.howieyoung91.chatgpt.client.Usage

data class EditResponse(
    var id: String? = null,
    var `object`: String? = null,
    var created: Long = 0,
    var model: String? = null,
    var choices: Array<Choice>,
    var usage: Usage? = null,
)
