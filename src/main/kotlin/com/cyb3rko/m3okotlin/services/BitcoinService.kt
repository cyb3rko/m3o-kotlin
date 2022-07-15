package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.BitcoinBalanceRequest
import com.cyb3rko.m3okotlin.data.BitcoinBalanceResponse
import com.cyb3rko.m3okotlin.data.BitcoinPriceRequest
import com.cyb3rko.m3okotlin.data.BitcoinPriceResponse
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
     * Get the BTC balance of an address
     * @since 0.2.2
     */
    suspend fun balance(address: String): BitcoinBalanceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Balance")) {
            body = BitcoinBalanceRequest(address)
        }
    }

    /**
     * Get the price of bitcoin
     * @since 0.1.0
     */
    suspend fun price(symbol: String = "BTCUSD"): BitcoinPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = BitcoinPriceRequest(symbol)
        }
    }
}
