package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.TwitterTrendsResponse.TwitterTrend
import com.cyb3rko.m3okotlin.data.TwitterUserResponse.TwitterProfile
import io.ktor.client.request.*

private const val SERVICE = "twitter"

/**
 * **Realtime twitter timeline & search**
 *
 * Retrieve the twitter timeline for a user or search for tweets without all the
 * extra baggage of the existing twitter API.
 *
 * @since 0.1.0
 */
object TwitterService {

    /**
     * Search for tweets with a simple query
     * @since 0.1.0
     */
    suspend fun search(query: String, limit: Int = 20): TwitterSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = TwitterSearchRequest(limit, query)
        }
    }

    /**
     * Get the timeline for a given user
     * @since 0.1.0
     */
    suspend fun timeline(username: String, limit: Int = 20): TwitterTimelineResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Timeline")) {
            body = TwitterTimelineRequest(limit, username)
        }
    }

    /**
     * Get the current global trending topics
     * @since 0.1.0
     */
    suspend fun trends(): TwitterTrendsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Trends"))
    }

    /**
     * Get a user's twitter profile
     * @since 0.1.0
     */
    suspend fun user(username: String): TwitterUserResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "User")) {
            body = TwitterUserRequest(username)
        }
    }

    suspend fun Tweet.timeline(limit: Int = 20) = timeline(this.username, limit)

    suspend fun Tweet.user() = user(this.username)

    suspend fun TwitterProfile.timeline(limit: Int = 20) = timeline(this.username, limit)

    suspend fun TwitterTrend.search(limit: Int = 20) = search(this.name, limit)
}
