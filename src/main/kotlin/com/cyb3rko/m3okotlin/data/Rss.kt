package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class RssAddRequest(
    val category: String,
    val name: String,
    val url: String
)

@Serializable
internal data class RssFeedRequest(
    val limit: Int,
    val name: String,
    val offset: Int
)

@Serializable
data class RssFeedResponse(val entries: List<RssFeedEntry>) {

    @Serializable
    data class RssFeedEntry(
        val date: String,
        val feed: String,
        val id: String,
        val link: String,
        val summary: String,
        val title: String
    )
}

@Serializable
data class RssListResponse(val feeds: List<RssFeed>) {

    @Serializable
    data class RssFeed(
        val category: String,
        val id: String,
        val name: String,
        val url: String
    )
}

@Serializable
internal data class RssRemoveRequest(val name: String)
