package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.GoogleRequest
import com.cyb3rko.m3okotlin.data.GoogleResponse
import io.ktor.client.request.*

private const val SERVICE = "google"

/**
 * **Google search service**
 *
 * Search for anything via Google. That's it.
 *
 * @since 0.1.0
 */
object GoogleService {

    /**
     * Search for videos on Google
     * @since 0.1.0
     */
    suspend fun search(query: String): GoogleResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = GoogleRequest(query)
        }
    }
}
