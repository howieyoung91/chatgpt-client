/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client.edit

import com.squareup.moshi.Json

/**
 * @author Howie Young
 * @date 2023/03/17 11:04
 */
data class EditRequest(
    var model: String,
    var instruction: String,
) {
    var input: String? = null
    var n: Int? = null
    var temperature: Double? = null

    @Json(name = "top_p")
    var topP: Double? = null

    enum class Model(val modelName: String) {
        TEXT_DAVINCI_EDIT_001("text-davinci-edit-001"),
        CODE_DAVINCI_EDIT_001("code-davinci-edit-001");

        companion object {
            val NAMES = arrayOf(
                TEXT_DAVINCI_EDIT_001.modelName,
                CODE_DAVINCI_EDIT_001.modelName
            )
        }
    }

    override fun toString(): String {
        return "EditRequest(model='$model', instruction='$instruction', input=$input, n=$n, temperature=$temperature, topP=$topP)"
    }
}
