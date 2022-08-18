package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class EthereumBalanceRequest(val address: String)

@Serializable
data class EthereumBalanceResponse(val balance: String)

@Serializable
internal data class EthereumBroadcastRequest(val hex: String)

@Serializable
data class EthereumBroadcastResponse(val hash: String)

@Serializable
internal data class EthereumTransactionRequest(val hash: String)

@Serializable
data class EthereumTransactionResponse(
    @SerialName("block_hash")
    val blockHash: String,
    @SerialName("block_number")
    val blockNumber: String,
    @SerialName("chain_id")
    val chainId: String,
    @SerialName("from_address")
    val fromAddress: String,
    val gas: String,
    val gas_price: String,
    val hash: String,
    val input: String,
    @SerialName("max_fee_per_gas")
    val maxFeePerGas: String,
    @SerialName("max_priority_fee_per_gas")
    val maxPriorityFeePerGas: String,
    val nonce: String,
    val r: String,
    val s: String,
    @SerialName("to_address")
    val toAddress: String,
    @SerialName("tx_index")
    val txIndex: Int,
    val type: String,
    val v: String,
    val value: String
)
