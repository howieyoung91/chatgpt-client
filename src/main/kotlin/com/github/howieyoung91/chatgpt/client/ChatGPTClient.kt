package com.github.howieyoung91.chatgpt.client

import com.github.howieyoung91.chatgpt.client.completion.CompletionRequest
import com.github.howieyoung91.chatgpt.client.completion.CompletionResponse
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
    init: Retrofit.Builder.() -> Unit = {
        client(
            OkHttpClient.Builder()
                .connectionPool(ConnectionPool(20, 10, TimeUnit.MINUTES))
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build()
        )
        baseUrl("https://api.openai.com")
        addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()))
    },
) {
    private val apiKey = "Bearer $apiKey"
    private val retrofitBuilder = Retrofit.Builder()

    init {
        init(retrofitBuilder)
    }

    private val chatgpt by lazy {
        retrofitBuilder.build()
            .create<OpenAiAPI>()
    }

    fun complete(request: CompletionRequest): Response<CompletionResponse> {
        val call = chatgpt.complete(request, apiKey)
        return call.execute()
    }

    fun complete(request: CompletionRequest, callback: Callback<CompletionResponse>) {
        val call = chatgpt.complete(request, apiKey)
        call.enqueue(callback)
    }
}


