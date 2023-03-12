package com.github.howieyoung91

import com.github.howieyoung91.completion.CompletionRequest
import com.github.howieyoung91.completion.CompletionResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiAPI {
    @POST("/v1/completions")
    @Headers("Content-Type: application/json")
    fun complete(@Body req: CompletionRequest, @Header("Authorization") apiKey: String): Call<CompletionResponse>
}