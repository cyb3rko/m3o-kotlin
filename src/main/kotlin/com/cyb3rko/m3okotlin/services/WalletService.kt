package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "wallet"

/**
 * **Virtual Wallet**
 *
 * A virtual wallet you to manage multiple currencies from anywhere. Credit,
 * debit, transfer and more.
 *
 * @since 0.3.0
 */
object WalletService {

    /**
     * Get the balance of a wallet
     * @since 0.3.0
     */
    suspend fun balance(id: String): WalletBalanceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Balance")) {
            body = WalletBalanceRequest(id)
        }
    }

    /**
     * Create a new wallet
     * @since 0.3.0
     */
    suspend fun create(
        description: String = "",
        id: String = "",
        name: String = ""
    ): WalletCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
            body = WalletCreateRequest(description, id, name)
        }
    }

    /**
     * Add credit to a wallet
     * @since 0.3.0
     */
    suspend fun credit(
        amount: Int,
        id: String,
        reference: String,
        idempotencyKey: String = "",
        visible: Boolean = false
    ): WalletCreditResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Credit")) {
            body = WalletCreditRequest(amount, id, idempotencyKey, reference, visible)
        }
    }

    /**
     * Debit a wallet
     * @since 0.3.0
     */
    suspend fun debit(
        amount: Int,
        id: String,
        reference: String,
        idempotencyKey: String = "",
        visible: Boolean = false
    ): WalletDebitResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Debit")) {
            body = WalletDebitRequest(amount, id, idempotencyKey, reference, visible)
        }
    }

    /**
     * Delete a wallet
     * @since 0.3.0
     */
    suspend fun delete(id: String) {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
            body = WalletDeleteRequest(id)
        }
    }

    /**
     * List your wallets
     * @since 0.3.0
     */
    suspend fun list(): WalletListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List"))
    }

    /**
     * Get wallet by id
     * @since 0.3.0
     */
    suspend fun read(id: String): WalletReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
            body = WalletReadRequest(id)
        }
    }

    /**
     * List the transactions for a wallet
     * @since 0.3.0
     */
    suspend fun transactions(id: String): WalletTransactionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Transactions")) {
            body = WalletTransactionsRequest(id)
        }
    }

    /**
     * Make a transfer from one wallet to another
     * @since 0.3.0
     */
    suspend fun transfer(
        amount: Int,
        fromId: String,
        toId: String,
        reference: String = "",
        visible: Boolean = false
    ) {
        return ktorHttpClient.post(getUrl(SERVICE, "Transfer")) {
            body = WalletTransferRequest(amount, fromId, reference, toId, visible)
        }
    }

    suspend fun Wallet.balance() = balance(this.id)

    suspend fun Wallet.credit(
        amount: Int,
        reference: String,
        idempotencyKey: String = "",
        visible: Boolean = false
    ) = credit(amount, this.id, reference, idempotencyKey, visible)

    suspend fun Wallet.debit(
        amount: Int,
        reference: String,
        idempotencyKey: String = "",
        visible: Boolean = false
    ) = debit(amount, this.id, reference, idempotencyKey, visible)

    suspend fun Wallet.delete() = delete(this.id)

    suspend fun Wallet.read() = read(this.id)

    suspend fun Wallet.transactions() = transactions(this.id)

    suspend fun Wallet.transferFrom(
        amount: Int,
        toId: String,
        reference: String = "",
        visible: Boolean = false
    ) = transfer(amount, this.id, toId, reference, visible)

    suspend fun Wallet.transferTo(
        amount: Int,
        fromId: String,
        reference: String = "",
        visible: Boolean = false
    ) = transfer(amount, fromId, this.id, reference, visible)
}
