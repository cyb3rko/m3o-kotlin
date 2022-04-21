package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.NewsRequest
import com.cyb3rko.m3okotlin.data.NewsResponse
import io.ktor.client.request.*

private const val SERVICE = "news"

object NewsService {

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
