package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.YouTubeEmbedRequest
import com.cyb3rko.m3okotlin.data.YouTubeEmbedResponse
import com.cyb3rko.m3okotlin.data.YouTubeSearchRequest
import com.cyb3rko.m3okotlin.data.YouTubeSearchResponse
import io.ktor.client.request.*

private const val SERVICE = "youtube"

object YouTubeService {

    suspend fun embed(url: String): YouTubeEmbedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Embed")) {
            body = YouTubeEmbedRequest(url)
        }
    }

    suspend fun search(query: String): YouTubeSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = YouTubeSearchRequest(query)
        }
    }
}