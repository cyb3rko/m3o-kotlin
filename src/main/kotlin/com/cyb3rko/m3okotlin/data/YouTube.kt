package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class YouTubeEmbedRequest(val url: String)

@Serializable
data class YouTubeEmbedResponse(
    @SerialName("embed_url")
    val embedUrl: String,
    @SerialName("html_script")
    val htmlScript: String,
    @SerialName("long_url")
    val longUrl: String,
    @SerialName("short_url")
    val shortUrl: String
)

@Serializable
internal data class YouTubeSearchRequest(val query: String)

@Serializable
data class YouTubeSearchResponse(val results: List<YouTubeSearchResult>) {

    @Serializable
    data class YouTubeSearchResult(
        val broadcasting: String,
        @SerialName("channel_id")
        val channelId: String,
        @SerialName("channel_title")
        val channelTitle: String,
        val description: String,
        val id: String,
        val kind: String,
        @SerialName("published_at")
        val publishedAt: String,
        val title: String,
        val url: String
    )
}
