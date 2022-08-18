package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "ethereum"

/**
 * **Ethereum API explorer**
 *
 * Explore the ethereum blockchain. Get balances, transactions and more.
 *
 * @since 0.3.2
 */
object EthereumService {

    /**
     * Get the balance of an ethereum wallet
     * @since 0.3.2
     */
    suspend fun balance(address: String): EthereumBalanceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Balance")) {
            body = EthereumBalanceRequest(address)
        }
    }

    /**
     * Broadcast presigned transaction to ethereum network
     * @since 0.3.2
     */
    suspend fun broadcast(address: String): EthereumBroadcastResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Broadcast")) {
            body = EthereumBroadcastRequest(address)
        }
    }

    /**
     * Get transaction details by hash
     * @since 0.3.2
     */
    suspend fun transaction(hash: String): EthereumTransactionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Transaction")) {
            body = EthereumTransactionRequest(hash)
        }
    }
}
