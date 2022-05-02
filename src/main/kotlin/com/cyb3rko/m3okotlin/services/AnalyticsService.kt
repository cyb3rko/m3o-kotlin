package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "analytics"

/**
 * **Track and retrieve events**
 *
 * The analytics service lets you create events, atomically increment them and
 * read their values.
 *
 * @since 0.1.0
 */
object AnalyticsService {

    /**
     * Delete an event
     * @since 0.1.0
     */
    suspend fun delete(name: String): AnalyticsDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = AnalyticsDeleteRequest(name)
        }
    }

    /**
     * List all events
     * @since 0.1.0
     */
    suspend fun list(): AnalyticsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Get a single event
     * @since 0.1.0
     */
    suspend fun read(name: String): AnalyticsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = AnalyticsReadRequest(name)
        }
    }

    /**
     * Track an event, it will be created if it doesn't exist
     * @since 0.1.0
     */
    suspend fun track(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Track")) {
            body = AnalyticsTrackRequest(name)
        }
    }
}
