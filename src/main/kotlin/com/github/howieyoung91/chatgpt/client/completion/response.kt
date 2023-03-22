/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client.completion

import com.github.howieyoung91.chatgpt.client.Choice
import com.github.howieyoung91.chatgpt.client.Usage

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
