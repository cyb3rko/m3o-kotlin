package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class BitcoinBalanceRequest(val address: String)

@Serializable
data class BitcoinBalanceResponse(val balance: String)

@Serializable
internal data class BitcoinPriceRequest(val symbol: String)

@Serializable
data class BitcoinPriceResponse(val price: Float, val symbol: String)

@Serializable
internal data class BitcoinTransactionRequest(val hash: String)

@Serializable
data class BitcoinTransactionResponse(
    @SerialName("block_height")
    val blockHeight: Int,
    @SerialName("block_index")
    val blockIndex: Int,
    @SerialName("double_spend")
    val doubleSpend: Boolean,
    val fee: Int,
    val hash: String,
    val inputs: List<TransactionInput>,
    @SerialName("lock_time")
    val lockTime: Int,
    val outputs: List<TransactionOutput>,
    val relay: String,
    val size: Int,
    @SerialName("tx_index")
    val txIndex: String,
    val version: Int,
    @SerialName("vin_sz")
    val vinSz: Int,
    @SerialName("vout_sz")
    val voutSz: Int,
    val weight: Int
) {

    @Serializable
    data class TransactionInput(
        @SerialName("prev_out")
        val prevOut: TransactionPrevOut,
        val script: String
    ) {

        @Serializable
        data class TransactionPrevOut(
            val address: String,
            val n: String,
            val script: String,
            val spent: Boolean,
            @SerialName("tx_index")
            val txIndex: String,
            val value: String
        )
    }

    @Serializable
    data class TransactionOutput(
        val address: String,
        val script: String,
        val spent: Boolean,
        @SerialName("tx_index")
        val txIndex: String,
        val value: String
    )
}
