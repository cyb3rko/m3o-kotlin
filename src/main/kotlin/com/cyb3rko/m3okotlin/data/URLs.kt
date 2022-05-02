package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class URLsListRequest(val shortURL: String)

@Serializable
data class URLsListResponse(val urlPairs: List<URL>) {

    @Serializable
    data class URL(
        val created: String,
        val destinationURL: String,
        val hitCount: String,
        val shortURL: String
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
