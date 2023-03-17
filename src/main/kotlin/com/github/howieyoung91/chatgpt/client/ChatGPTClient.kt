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
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * @author Howie Young
 * @date 2023/03/12 02:41
 */
open class ChatGPTClient(
    apiKey: String,
    init: Retrofit.Builder.() -> Unit,
) {
    private var apiKey = if (apiKey.isEmpty()) "" else "Bearer $apiKey"
    protected val retrofitBuilder = Retrofit.Builder()

    init {
        init(retrofitBuilder)
    }

    private val chatgpt by lazy {
        retrofitBuilder.build()
            .create<OpenAiAPI>()
    }

    constructor(apiKey: String) : this(apiKey, {
        client(
            OkHttpClient.Builder()
                .connectionPool(ConnectionPool())
                .callTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
        )
        baseUrl("https://api.openai.com")
        addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        )
    })

    fun complete(request: CompletionRequest): Response<CompletionResponse> {
        val call = chatgpt.complete(request, apiKey)
        return call.execute()
    }

    fun complete(request: CompletionRequest, callback: Callback<CompletionResponse>) {
        val call = chatgpt.complete(request, apiKey)
        call.enqueue(callback)
    }

    fun chatComplete(request: ChatCompletionRequest): Response<ChatCompletionResponse> {
        val call = chatgpt.chatComplete(request, apiKey)
        return call.execute()
    }

    fun chatComplete(request: ChatCompletionRequest, callback: Callback<ChatCompletionResponse>) {
        val call = chatgpt.chatComplete(request, apiKey)
        call.enqueue(callback)
    }

    fun edit(request: EditRequest): Response<EditResponse> {
        val call = chatgpt.edit(request, apiKey)
        return call.execute()
    }

    fun edit(request: EditRequest, callback: Callback<EditResponse>) {
        val call = chatgpt.edit(request, apiKey)
        call.enqueue(callback)
    }
}