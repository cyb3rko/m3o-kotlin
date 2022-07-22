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
object UrlsService {

    /**
     * Create a URL
     * @since 0.2.3
     */
    suspend fun create(destinationUrl: String, id: String): UrlsCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = UrlsCreateRequest(destinationUrl, id)
        }
    }

    /**
     * Delete a URL
     * @since 0.2.2
     */
    suspend fun delete(id: String = "", shortUrl: String = "") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = UrlsDeleteRequest(id, shortUrl)
        }
    }

    /**
     * List all the shortened URLs
     * @since 0.1.0
     */
    suspend fun list(shortUrl: String = ""): UrlsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = UrlsListRequest(shortUrl)
        }
    }

    /**
     * Resolve returns the destination URL of a short URL.
     * @since 0.2.3
     */
    suspend fun resolve(shortUrl: String): UrlsResolveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Resolve")) {
            body = UrlsResolveRequest(shortUrl)
        }
    }

    /**
     * Shorten a long URL
     * @since 0.1.0
     */
    suspend fun shorten(destinationUrl: String): UrlsShortenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Shorten")) {
            body = UrlsShortenRequest(destinationUrl)
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
            body = UrlsUpdateRequest(destinationUrl, id, shortUrl)
        }
    }
}
