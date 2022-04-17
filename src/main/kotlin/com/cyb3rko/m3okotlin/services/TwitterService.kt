package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "twitter"

object TwitterService {

    suspend fun search(query: String, limit: Int = 20): TwitterSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = TwitterSearchRequest(limit, query)
        }
    }

    suspend fun timeline(username: String, limit: Int = 20): TwitterTimelineResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Timeline")) {
            body = TwitterTimelineRequest(limit, username)
        }
    }

    suspend fun trends(): TwitterTrendsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Trends"))
    }

    suspend fun user(username: String): TwitterUserResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "User")) {
            body = TwitterUserRequest(username)
        }
    }
}