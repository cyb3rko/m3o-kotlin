package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.GifsRequest
import com.cyb3rko.m3okotlin.data.GifsResponse
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
    ): GifsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = GifsRequest(lang, limit, offset, query, rating)
        }
    }
}
