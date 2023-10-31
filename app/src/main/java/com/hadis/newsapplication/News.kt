package com.hadis.newsapplication

data class News(
    var title: String,
    var description: String,
    var date: String,
    var writer: String,
    var imageUri: String,
    var linkUrl: String
) {
}
//say POJO