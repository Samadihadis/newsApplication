package com.hadis.newsapplication

enum class ResponseModel(
    var status: String,
    var totalResult: Int,
    var articles: List<News>
) {
}