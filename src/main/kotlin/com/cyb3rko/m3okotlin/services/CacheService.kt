package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "cache"

object CacheService {

    suspend fun decrement(key: String, value: Int): CacheDecrementResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Decrement")) {
            body = CacheDecrementRequest(key, value)
        }
    }

    suspend fun delete(key: String): CacheDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = CacheDeleteRequest(key)
        }
    }

    suspend fun get(key: String): CacheGetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Get")) {
            body = CacheGetRequest(key)
        }
    }

    suspend fun increment(key: String, value: Int): CacheIncrementResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Increment")) {
            body = CacheIncrementRequest(key, value)
        }
    }

    suspend fun listKeys(): CacheListKeysResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListKeys"))
    }

    suspend fun set(
        key: String,
        value: String,
        ttl: Int = 0,
    ): CacheSetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Set")) {
            body = CacheSetRequest(key, ttl, value)
        }
    }
}