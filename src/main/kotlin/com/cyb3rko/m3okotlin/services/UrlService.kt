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
object UrlService {

    /**
     * Create a URL
     * @since 0.2.4
     */
    suspend fun create(destinationUrl: String, id: String): UrlCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = UrlCreateRequest(destinationUrl, id)
        }
    }

    /**
     * Delete a URL
     * @since 0.2.2
     */
    suspend fun delete(id: String = "", shortUrl: String = "") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = UrlDeleteRequest(id, shortUrl)
        }
    }

    /**
     * List all the shortened URLs
     * @since 0.1.0
     */
    suspend fun list(shortUrl: String = ""): UrlListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = UrlListRequest(shortUrl)
        }
    }

    /**
     * Resolve returns the destination URL of a short URL.
     * @since 0.2.4
     */
    suspend fun resolve(shortUrl: String): UrlResolveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Resolve")) {
            body = UrlResolveRequest(shortUrl)
        }
    }

    /**
     * Shorten a long URL
     * @since 0.1.0
     */
    suspend fun shorten(destinationUrl: String): UrlShortenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Shorten")) {
            body = UrlShortenRequest(destinationUrl)
        }
    }

    /**
     * Update the destination for a short URL
     * @since 0.2.4
     */
    suspend fun update(
        destinationUrl: String,
        id: String = "",
        shortUrl: String = ""
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = UrlUpdateRequest(destinationUrl, id, shortUrl)
        }
    }
}
