package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.CarbonResponse
import io.ktor.client.request.*

private const val SERVICE = "carbon"

/**
 * **Purchase carbon offsets**
 *
 * Purchase carbon offsets to help climate change and achieve carbon
 * neutrality. Offset purchases are currently limited to 1KG (0.001 tonne) per
 * request. Make multiple requests to purchase the required amount.
 *
 * @since 0.1.0
 */
object CarbonService {

    /**
     * Purchase 1KG (0.001 tonne) of carbon offsets in a single request
     * @since 0.1.0
     */
    suspend fun offset(): CarbonResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Offset"))
    }
}
