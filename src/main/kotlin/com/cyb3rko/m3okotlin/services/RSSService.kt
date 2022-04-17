package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "rss"

object RSSService {

    suspend fun add(
        name: String,
        url: String,
        category: String = ""
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Add")) {
            body = RSSAddRequest(category, name, url)
        }
    }

    suspend fun feed(
        name: String,
        limit: Int = 25,
        offset: Int = 0
    ): RSSFeedResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Feed")) {
            body = RSSFeedRequest(limit, name, offset)
        }
    }

    suspend fun list(): RSSListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun remove(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Remove")) {
            body = RSSRemoveRequest(name)
        }
    }
}