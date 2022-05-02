package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.ThumbnailRequest
import com.cyb3rko.m3okotlin.data.ThumbnailResponse
import io.ktor.client.request.*

private const val SERVICE = "thumbnail"

/**
 * **Create website thumbnails**
 *
 * A quick and easy way to create a thumbnail screenshot for any website.
 *
 * @since 0.1.0
 */
object ThumbnailService {

    /**
     * Create a thumbnail screenshot by passing in a url, height and width
     * @since 0.1.0
     */
    suspend fun screenshot(url: String, height: Int = 0, width: Int = 0): ThumbnailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
            body = ThumbnailRequest(height, url, width)
        }
    }
}
