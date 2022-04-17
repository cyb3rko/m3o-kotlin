package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.BitcoinRequest
import com.cyb3rko.m3okotlin.data.BitcoinResponse
import io.ktor.client.request.*

private const val SERVICE = "bitcoin"

object BitcoinService {

    suspend fun price(symbol: String = "BTCUSD"): BitcoinResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = BitcoinRequest(symbol)
        }
    }
}