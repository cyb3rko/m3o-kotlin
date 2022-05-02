package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class QRCodesRequest(val size: Int, val text: String)

@Serializable
data class QRCodesResponse(val qr: String)
