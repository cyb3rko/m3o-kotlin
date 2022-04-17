package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class URLsListRequest(val shortURL: String)

@Serializable
data class URLsListResponse(val urlPairs: List<URLsEntry>) {

    @Serializable
    data class URLsEntry(
        val shortURL: String,
        val destinationURL: String,
        val created: String,
        val hitCount: String
    )
}

@Serializable
internal data class URLsProxyRequest(val shortURL: String)

@Serializable
data class URLsProxyResponse(val destinationURL: String)

@Serializable
internal data class URLsShortenRequest(val destinationURL: String)

@Serializable
data class URLsShortenResponse(val shortURL: String)