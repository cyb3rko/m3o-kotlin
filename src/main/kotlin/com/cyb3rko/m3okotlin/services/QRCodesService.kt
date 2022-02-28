package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.YouTubeEmbedRequest
import io.ktor.client.request.*

private const val SERVICE = "qr"

object QRCodesService {

    suspend fun generate(text: String, size: Int = 256): QRCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = QRCodesRequest(size, text)
        }
    }
}