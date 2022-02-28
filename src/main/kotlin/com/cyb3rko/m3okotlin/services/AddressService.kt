package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AddressRequest
import com.cyb3rko.m3okotlin.data.AddressResponse
import io.ktor.client.request.*

private const val SERVICE = "address"

object AddressService {

    suspend fun lookupPostcode(postcode: String): AddressResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
            body = AddressRequest(postcode)
        }
    }
}