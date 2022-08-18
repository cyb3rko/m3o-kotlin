package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
data class QrCodesResponse(val codes: List<QrCode>) {

    @Serializable
    data class QrCode(
        val created: String,
        val file: String,
        val id: String,
        val text: String
    )
}

@Serializable
internal data class QrCodesGenerateRequest(val size: Int, val text: String)

@Serializable
data class QrCodesGenerateResponse(val qr: String)
