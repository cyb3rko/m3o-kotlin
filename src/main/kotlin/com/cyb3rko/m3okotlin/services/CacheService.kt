package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "cache"

/**
 * **Fast access key-value storage**
 *
 * The cache service provides simple get/set/delete key-value storage. Values
 * can be stored with an optional time-to-live (TTL) to automatically expire
 * entries.
 *
 * @since 0.1.0
 */
object CacheService {

    /**
     * Decrement a value (if it's a number). If key not found it is equivalent
     * to set.
     * @since 0.1.0
     */
    suspend fun decrement(key: String, value: Int): CacheDecrementResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Decrement")) {
            body = CacheDecrementRequest(key, value)
        }
    }

    /**
     * Delete a value from the cache. If key not found a success response is
     * returned.
     * @since 0.1.0
     */
    suspend fun delete(key: String): CacheDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = CacheDeleteRequest(key)
        }
    }

    /**
     * Get an item from the cache by key. If key is not found, an empty
     * response is returned.
     * @since 0.1.0
     */
    suspend fun get(key: String): CacheGetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Get")) {
            body = CacheGetRequest(key)
        }
    }

    /**
     * Increment a value (if it's a number). If key not found it is equivalent
     * to set.
     * @since 0.1.0
     */
    suspend fun increment(key: String, value: Int): CacheIncrementResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Increment")) {
            body = CacheIncrementRequest(key, value)
        }
    }

    /**
     * List all the available keys
     * @since 0.1.0
     */
    suspend fun listKeys(): CacheListKeysResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListKeys"))
    }

    /**
     * Set an item in the cache. Overwrites any existing value already set.
     * @since 0.1.0
     */
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
