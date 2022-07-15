package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "url"

/**
 * **URL shortening, sharing, and tracking**
 *
 * The url service provides one time short urls for anything. Shorten, share,
 * and then track the usage.
 *
 * @since 0.1.0
 */
object URLsService {

    /**
     * Delete a URL
     * @since 0.2.2
     */
    suspend fun delete(shortURL: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = URLsDeleteRequest(shortURL)
        }
    }

    /**
     * List all the shortened URLs
     * @since 0.1.0
     */
    suspend fun list(shortURL: String = ""): URLsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = URLsListRequest(shortURL)
        }
    }

    /**
     * Proxy returns the destination URL of a short URL.
     * @since 0.1.0
     */
    suspend fun proxy(shortURL: String): URLsProxyResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Proxy")) {
            body = URLsProxyRequest(shortURL)
        }
    }

    /**
     * Shorten a long URL
     * @since 0.1.0
     */
    suspend fun shorten(destinationURL: String): URLsShortenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Shorten")) {
            body = URLsShortenRequest(destinationURL)
        }
    }
}
