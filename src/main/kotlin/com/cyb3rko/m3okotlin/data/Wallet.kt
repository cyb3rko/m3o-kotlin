package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

// Requests & Responses + Data (single use)

@Serializable
internal data class WalletBalanceRequest(val id: String)

@Serializable
data class WalletBalanceResponse(val balance: Int)

@Serializable
internal data class WalletCreateRequest(
    val description: String,
    val id: String,
    val name: String
)

@Serializable
data class WalletCreateResponse(val account: Wallet)

@Serializable
internal data class WalletCreditRequest(
    val amount: Int,
    val id: String,
    @SerialName("idempotency_key")
    val idempotencyKey: String,
    val reference: String,
    val visible: Boolean
)

@Serializable
data class WalletCreditResponse(val balance: Int)

@Serializable
internal data class WalletDebitRequest(
    val amount: Int,
    val id: String,
    @SerialName("idempotency_key")
    val idempotencyKey: String,
    val reference: String,
    val visible: Boolean
)

@Serializable
data class WalletDebitResponse(val balance: Int)

@Serializable
internal data class WalletDeleteRequest(val id: String)

@Serializable
data class WalletListResponse(val accounts: List<Wallet>)

@Serializable
internal data class WalletReadRequest(val id: String)

@Serializable
data class WalletReadResponse(val account: Wallet)

@Serializable
internal data class WalletTransactionsRequest(val id: String)

@Serializable
data class WalletTransactionsResponse(val transactions: List<WalletTransaction>) {

    @Serializable
    data class WalletTransaction(
        val amount: Int,
        val created: String,
        val id: String,
        val metadata: JsonElement,
        val reference: String
    )
}

@Serializable
internal data class WalletTransferRequest(
    val amount: Int,
    @SerialName("from_id")
    val fromId: String,
    val reference: String,
    @SerialName("to_id")
    val toId: String,
    val visible: Boolean
)

// Data (multiple use)

@Serializable
data class Wallet(
    val balance: Int,
    val description: String,
    val id: String,
    val name: String
)
