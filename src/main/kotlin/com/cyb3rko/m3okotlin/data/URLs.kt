package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class URLsCreateRequest(
    @SerialName("destinationURL")
    val destinationUrl: String,
    val id: String
)

@Serializable
data class URLsCreateResponse(val url: Url)

@Serializable
internal data class URLsDeleteRequest(
    val id: String,
    val shortURL: String
)

@Serializable
internal data class URLsListRequest(val shortURL: String)

@Serializable
data class URLsListResponse(val urlPairs: List<Url>)

@Serializable
internal data class URLsResolveRequest(@SerialName("shortURL") val shortUrl: String)

@Serializable
data class URLsResolveResponse(@SerialName("destinationURL") val destinationUrl: String)

@Serializable
internal data class URLsShortenRequest(val destinationURL: String)

@Serializable
data class URLsShortenResponse(val shortURL: String)

// Data (multiple use)

@Serializable
data class Url(
    val created: String,
    @SerialName("destinationURL")
    val destinationUrl: String,
    val hitCount: String,
    val id: String,
    @SerialName("shortURL")
    val shortUrl: String
)
