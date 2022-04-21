package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class CacheDecrementRequest(val key: String, val value: Int)

@Serializable
data class CacheDecrementResponse(val key: String, val value: Int)

@Serializable
internal data class CacheDeleteRequest(val key: String)

@Serializable
data class CacheDeleteResponse(val status: String)

@Serializable
internal data class CacheGetRequest(val key: String)

@Serializable
data class CacheGetResponse(
    val key: String? = null,
    val ttl: Int? = null,
    val value: String
)

@Serializable
internal data class CacheIncrementRequest(val key: String, val value: Int)

@Serializable
data class CacheIncrementResponse(val key: String, val value: Int)

@Serializable
data class CacheListKeysResponse(val keys: List<String>)

@Serializable
internal data class CacheSetRequest(
    val key: String,
    val ttl: Int,
    val value: String
)

@Serializable
data class CacheSetResponse(val status: String)