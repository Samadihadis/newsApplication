package com.hadis.newsapplication

class ResponseModel(
    var status: String,
    var totalResult: Int,
    var articles: List<News>
)