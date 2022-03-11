package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "sentiment"

object SentimentService {

    suspend fun analyze(text: String, lang: String = ""): SentimentResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Analyze")) {
            body = SentimentRequest(text, lang)
        }
    }
}