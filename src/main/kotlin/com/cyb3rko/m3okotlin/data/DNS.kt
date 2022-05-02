package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DNSRequest(val name: String, val type: String)

@Serializable
data class DNSResponse(
    @SerialName("AD")
    val ad: Boolean,
    val answer: List<DNSQueryAnswer>,
    @SerialName("CD")
    val cd: Boolean,
    val provider: String,
    val question: List<DNSQueryQuestion>,
    @SerialName("RA")
    val ra: Boolean,
    @SerialName("RD")
    val rd: Boolean,
    val status: Int,
    @SerialName("TC")
    val tc: Boolean
) {

    @Serializable
    data class DNSQueryAnswer(
        val data: String,
        val name: String,
        @SerialName("TTL")
        val ttl: Int,
        val type: Int,
    )

    @Serializable
    data class DNSQueryQuestion(val name: String, val type: Int)
}
