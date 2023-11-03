package com.hadis.newsapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("top-Headlines")
    suspend fun getNews(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String
    ): Response<ResponseModel>
}