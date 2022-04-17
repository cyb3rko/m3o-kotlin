package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "analytics"

object AnalyticsService {

    suspend fun delete(name: String): AnalyticsDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = AnalyticsDeleteRequest(name)
        }
    }

    suspend fun list(): AnalyticsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun read(name: String): AnalyticsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = AnalyticsReadRequest(name)
        }
    }

    suspend fun track(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Track")) {
            body = AnalyticsTrackRequest(name)
        }
    }
}