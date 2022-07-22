package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class QrCodesRequest(val size: Int, val text: String)

@Serializable
data class QrCodesResponse(val qr: String)
