package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.SentimentRequest
import com.cyb3rko.m3okotlin.data.SentimentResponse
import io.ktor.client.request.*

private const val SERVICE = "sentiment"

/**
 * **Real time sentiment analysis**
 *
 * The sentiment service provides rudimentary sentiment analysis on text
 *
 * @since 0.1.0
 */
object SentimentService {

    /**
     * Analyze and score a piece of text
     * @since 0.1.0
     */
    suspend fun analyze(text: String, lang: String = ""): SentimentResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Analyze")) {
            body = SentimentRequest(text, lang)
        }
    }
}
