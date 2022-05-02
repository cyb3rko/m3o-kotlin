package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.NewsRequest
import com.cyb3rko.m3okotlin.data.NewsResponse
import io.ktor.client.request.*

private const val SERVICE = "news"

/**
 * **Get the latest news**
 *
 * Get the latest news headlines from anywhere in the world
 *
 * @since 0.1.0
 */
object NewsService {

    /**
     * Get the latest news headlines
     * @since 0.1.0
     */
    suspend fun headlines(
        locale: String,
        date: String = "",
        language: String = ""
    ): NewsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Headlines")) {
            body = NewsRequest(date, language, locale)
        }
    }
}
