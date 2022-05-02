package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.JokesRequest
import com.cyb3rko.m3okotlin.data.JokesResponse
import io.ktor.client.request.*

private const val SERVICE = "joke"

/**
 * **Funny Jokes**
 *
 * A simple set random funny jokes to tell friends and family
 *
 * @since 0.1.0
 */
object JokesService {

    /**
     * Get a random joke
     * @since 0.1.0
     */
    suspend fun random(count: Int = 1): JokesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
            body = JokesRequest(count)
        }
    }
}
