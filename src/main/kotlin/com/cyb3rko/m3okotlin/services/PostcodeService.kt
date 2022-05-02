package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.PostcodeLookupRequest
import com.cyb3rko.m3okotlin.data.PostcodeLookupResponse
import io.ktor.client.request.*

private const val SERVICE = "postcode"

/**
 * **Fast UK postcode lookup**
 *
 * Lookup UK postcodes for their related latitude/longitude, region, and
 * additional information.
 *
 * @since 0.1.0
 */
object PostcodeService {

    /**
     * Lookup a postcode to retrieve the related region, county, etc
     * @since 0.1.0
     */
    suspend fun lookup(postcode: String): PostcodeLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = PostcodeLookupRequest(postcode)
        }
    }
}
