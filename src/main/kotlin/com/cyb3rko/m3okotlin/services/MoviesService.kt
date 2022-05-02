package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.MoviesRequest
import com.cyb3rko.m3okotlin.data.MoviesResponse
import io.ktor.client.request.*

private const val SERVICE = "movie"

/**
 * **Search for movies**
 *
 * Search for movies by IMDb ID or title.
 *
 * @since 0.1.0
 */
object MoviesService {

    /**
     * Search for movies by simple text search
     * @since 0.1.0
     */
    suspend fun search(
        query: String,
        language: String = "",
        page: Int = 0,
        primaryReleaseYear: Int = 0,
        region: String = "",
        year: Int = 0
    ): MoviesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = MoviesRequest(language, page, primaryReleaseYear, query, region, year)
        }
    }
}
