package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AddressRequest
import com.cyb3rko.m3okotlin.data.AddressResponse
import com.cyb3rko.m3okotlin.data.ThumbnailRequest
import com.cyb3rko.m3okotlin.data.ThumbnailResponse
import io.ktor.client.request.*

private const val SERVICE = "thumbnail"

object ThumbnailService {

    suspend fun screenshot(url: String, height: Int = 0, width: Int = 0): ThumbnailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
            body = ThumbnailRequest(height, url, width)
        }
    }
}