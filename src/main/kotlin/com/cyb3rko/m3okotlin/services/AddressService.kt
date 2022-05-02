package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AddressRequest
import com.cyb3rko.m3okotlin.data.AddressResponse
import io.ktor.client.request.*

private const val SERVICE = "address"

/**
 * **Address lookup by postcode**
 *
 * Lookup UK addresses by postcode. Simply provide a valid postcode and get a
 * full list of addresses.
 *
 * @since 0.1.0
 */
object AddressService {

    /**
     * Lookup a list of UK addresses by postcode
     * @since 0.1.0
     */
    suspend fun lookupPostcode(postcode: String): AddressResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
            body = AddressRequest(postcode)
        }
    }
}
