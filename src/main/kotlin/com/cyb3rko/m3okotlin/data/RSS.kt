package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class RSSAddRequest(
    val category: String,
    val name: String,
    val url: String
)

@Serializable
internal data class RSSFeedRequest(
    val limit: Int,
    val name: String,
    val offset: Int
)

@Serializable
data class RSSFeedResponse(val entries: List<RSSFeedEntry>) {

    @Serializable
    data class RSSFeedEntry(
        val id: String,
        val feed: String,
        val link: String,
        val title: String,
        val summary: String,
        val date: String
    )
}

@Serializable
data class RSSListResponse(val feeds: List<RSSFeed>) {

    @Serializable
    data class RSSFeed(
        val id: String,
        val name: String,
        val url: String,
        val category: String
    )
}

@Serializable
internal data class RSSRemoveRequest(val name: String)