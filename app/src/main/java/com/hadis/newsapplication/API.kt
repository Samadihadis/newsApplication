package com.hadis.newsapplication

import retrofit2.http.GET

interface API {
    @GET("top-Headline")


    fun getNews()
}