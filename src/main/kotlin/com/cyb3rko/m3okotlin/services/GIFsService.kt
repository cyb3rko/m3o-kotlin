package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.GIFsRequest
import com.cyb3rko.m3okotlin.data.GIFsResponse
import io.ktor.client.request.*

private const val SERVICE = "gifs"

/**
 * **Quick and simple GIF search**
 *
 * Add GIFs to your project with keyword search and results in multiple sizes
 * and formats.
 *
 * @since 0.1.0
 */
object GIFsService {

    /**
     * Search for a GIF
     * @since 0.1.0
     */
    suspend fun search(
        query: String,
        limit: Int = 25,
        offset: Int = 0,
        lang: String = "",
        rating: String = "g"
    ): GIFsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = GIFsRequest(lang, limit, offset, query, rating)
        }
    }
}
