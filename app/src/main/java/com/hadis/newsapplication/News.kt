package com.hadis.newsapplication

data class News(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) {
}
//say POJO

//https://newsapi.org/v2/top-headlines?sources=techcrunch&apikey=2480c92d4b7a40c3ad46f1fe47e99a15