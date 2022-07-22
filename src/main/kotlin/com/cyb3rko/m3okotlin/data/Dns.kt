package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DnsRequest(val name: String, val type: String)

@Serializable
data class DnsResponse(
    @SerialName("AD")
    val ad: Boolean,
    val answer: List<DnsQueryAnswer>,
    @SerialName("CD")
    val cd: Boolean,
    val provider: String,
    val question: List<DnsQueryQuestion>,
    @SerialName("RA")
    val ra: Boolean,
    @SerialName("RD")
    val rd: Boolean,
    val status: Int,
    @SerialName("TC")
    val tc: Boolean
) {

    @Serializable
    data class DnsQueryAnswer(
        val data: String,
        val name: String,
        @SerialName("TTL")
        val ttl: Int,
        val type: Int,
    )

    @Serializable
    data class DnsQueryQuestion(val name: String, val type: Int)
}
