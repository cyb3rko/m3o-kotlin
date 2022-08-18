package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.QrCodesGenerateRequest
import com.cyb3rko.m3okotlin.data.QrCodesGenerateResponse
import com.cyb3rko.m3okotlin.data.QrCodesResponse
import io.ktor.client.request.*

private const val SERVICE = "qr"

/**
 * **QR code generator**
 *
 * Quickly generate QR Codes for whatever you like with a single api call.
 * Typically, used for website URLs but could be any text like email addresses,
 * phone numbers, addresses etc.
 *
 * @since 0.1.0
 */
object QrCodesService {

    /**
     * List your QR codes
     * @since 0.3.2
     */
    suspend fun codes(): QrCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Codes"))
    }

    /**
     * Generate a QR code with a specific text and size
     * @since 0.1.0
     */
    suspend fun generate(text: String, size: Int = 256): QrCodesGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = QrCodesGenerateRequest(size, text)
        }
    }
}
