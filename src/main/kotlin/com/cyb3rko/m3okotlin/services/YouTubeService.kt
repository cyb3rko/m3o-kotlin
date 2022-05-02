package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.YouTubeEmbedRequest
import com.cyb3rko.m3okotlin.data.YouTubeEmbedResponse
import com.cyb3rko.m3okotlin.data.YouTubeSearchRequest
import com.cyb3rko.m3okotlin.data.YouTubeSearchResponse
import io.ktor.client.request.*

private const val SERVICE = "youtube"

/**
 * **Search for YouTube videos**
 *
 * Simple search for YouTube videos. Find whatever you're looking for
 * programmatically.
 *
 * @since 0.1.0
 */
object YouTubeService {

    /**
     * Embed a YouTube video
     * @since 0.1.0
     */
    suspend fun embed(url: String): YouTubeEmbedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Embed")) {
            body = YouTubeEmbedRequest(url)
        }
    }

    /**
     * Search for videos on YouTube
     * @since 0.1.0
     */
    suspend fun search(query: String): YouTubeSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = YouTubeSearchRequest(query)
        }
    }
}
