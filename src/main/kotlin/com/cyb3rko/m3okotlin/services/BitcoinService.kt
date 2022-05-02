package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.BitcoinRequest
import com.cyb3rko.m3okotlin.data.BitcoinResponse
import io.ktor.client.request.*

private const val SERVICE = "bitcoin"

/**
 * **Realtime Bitcoin price**
 *
 * Get the price of bitcoin in real time. Price is updated every 5 mins.
 *
 * @since 0.1.0
 */
object BitcoinService {

    /**
     * Get the price of bitcoin
     * @since 0.1.0
     */
    suspend fun price(symbol: String = "BTCUSD"): BitcoinResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = BitcoinRequest(symbol)
        }
    }
}
