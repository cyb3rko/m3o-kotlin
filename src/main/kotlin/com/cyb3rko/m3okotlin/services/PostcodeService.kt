package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "postcode"

object PostcodeService {

    suspend fun lookup(postcode: String): PostcodeLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = PostcodeLookupRequest(postcode)
        }
    }
}