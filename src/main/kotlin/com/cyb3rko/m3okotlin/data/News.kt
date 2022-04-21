package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NewsRequest(
    val date: String,
    val language: String,
    val locale: String
)

@Serializable
data class NewsResponse(val articles: List<NewsHeadline>) {

    @Serializable
    data class NewsHeadline(
        val categories: List<String>,
        val description: String,
        @SerialName("image_url")
        val imageURL: String,
        val keywords: String,
        val language: String,
        val locale: String,
        @SerialName("published_at")
        val publishedAt: String,
        val snippet: String,
        val source: String,
        val title: String,
        val url: String
    )
}
