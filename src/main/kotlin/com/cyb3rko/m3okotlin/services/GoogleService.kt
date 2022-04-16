package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.GoogleRequest
import com.cyb3rko.m3okotlin.data.GoogleResponse
import io.ktor.client.request.*

private const val SERVICE = "google"

object GoogleService {

    suspend fun search(query: String): GoogleResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = GoogleRequest(query)
        }
    }
}