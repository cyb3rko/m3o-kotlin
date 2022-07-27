package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class UrlCreateRequest(
    @SerialName("destinationURL")
    val destinationUrl: String,
    val id: String
)

@Serializable
data class UrlCreateResponse(val url: Url)

@Serializable
internal data class UrlDeleteRequest(
    val id: String,
    @SerialName("shortURL")
    val shortUrl: String
)

@Serializable
internal data class UrlListRequest(@SerialName("shortURL") val shortUrl: String)

@Serializable
data class UrlListResponse(val urlPairs: List<Url>)

@Serializable
internal data class UrlResolveRequest(@SerialName("shortURL") val shortUrl: String)

@Serializable
data class UrlResolveResponse(@SerialName("destinationURL") val destinationUrl: String)

@Serializable
internal data class UrlShortenRequest(@SerialName("destinationURL") val destinationUrl: String)

@Serializable
data class UrlShortenResponse(@SerialName("shortURL") val shortUrl: String)

@Serializable
internal data class UrlUpdateRequest(
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
