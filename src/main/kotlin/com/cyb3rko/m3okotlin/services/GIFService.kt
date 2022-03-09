package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "gifs"

object GIFService {

    suspend fun search(
        query: String,
        limit: Int = 25,
        offset: Int = 0,
        lang: String = "",
        rating: String = "g"
    ): GIFResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = GIFRequest(lang, limit, offset, query, rating)
        }
    }
}