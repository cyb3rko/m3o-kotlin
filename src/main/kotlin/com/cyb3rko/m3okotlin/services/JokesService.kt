package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "joke"

object JokesService {

    suspend fun random(count: Int = 1): JokesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
            body = JokesRequest(count)
        }
    }
}