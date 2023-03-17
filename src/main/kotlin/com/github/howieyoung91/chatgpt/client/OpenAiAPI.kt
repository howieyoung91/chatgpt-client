/*
 * Copyright ©2023 Howie Young
 * Licensed under the GPL version 3
 */

package com.github.howieyoung91.chatgpt.client

import com.github.howieyoung91.chatgpt.client.chat.ChatCompletionRequest
import com.github.howieyoung91.chatgpt.client.chat.ChatCompletionResponse
import com.github.howieyoung91.chatgpt.client.completion.CompletionRequest
import com.github.howieyoung91.chatgpt.client.completion.CompletionResponse
import com.github.howieyoung91.chatgpt.client.edit.EditRequest
import com.github.howieyoung91.chatgpt.client.edit.EditResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiAPI {
    @POST("/v1/completions")
    @Headers("Content-Type: application/json")
    fun complete(@Body req: CompletionRequest, @Header("Authorization") apiKey: String): Call<CompletionResponse>

    @POST("/v1/chat/completions")
    @Headers("Content-Type: application/json")
    fun chatComplete(
        @Body
        req: ChatCompletionRequest,
        @Header("Authorization")
        apiKey: String,
    ): Call<ChatCompletionResponse>

    @POST("/v1/edits")
    @Headers("Content-Type: application/json")
    fun edit(
        @Body
        req: EditRequest,
        @Header("Authorization")
        apiKey: String,
    ): Call<EditResponse>
}