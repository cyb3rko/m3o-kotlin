package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class UrlsCreateRequest(
    @SerialName("destinationURL")
    val destinationUrl: String,
    val id: String
)

@Serializable
data class UrlsCreateResponse(val url: Url)

@Serializable
internal data class UrlsDeleteRequest(
    val id: String,
    @SerialName("shortURL")
    val shortUrl: String
)

@Serializable
internal data class UrlsListRequest(@SerialName("shortURL") val shortUrl: String)

@Serializable
data class UrlsListResponse(val urlPairs: List<Url>)

@Serializable
internal data class UrlsResolveRequest(@SerialName("shortURL") val shortUrl: String)

@Serializable
data class UrlsResolveResponse(@SerialName("destinationURL") val destinationUrl: String)

@Serializable
internal data class UrlsShortenRequest(@SerialName("destinationURL") val destinationUrl: String)

@Serializable
data class UrlsShortenResponse(@SerialName("shortURL") val shortUrl: String)

@Serializable
internal data class UrlsUpdateRequest(
    @SerialName("destinationURL")
    val destinationUrl: String,
    val id: String,
    @SerialName("shortURL")
    val shortUrl: String
)

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
