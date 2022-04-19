package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.MemegenGenerateRequest
import com.cyb3rko.m3okotlin.data.MemegenGenerateResponse
import com.cyb3rko.m3okotlin.data.MemegenTemplatesResponse
import io.ktor.client.request.*

private const val SERVICE = "memegen"

object MemegenService {

    suspend fun generate(
        bottomText: String,
        id: String,
        topText: String,
        font: String = "impact",
        maxFontSize: String = "50px"
    ): MemegenGenerateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Generate")) {
            body = MemegenGenerateRequest(bottomText, font, id, maxFontSize, topText)
        }
    }

    suspend fun templates(): MemegenTemplatesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Templates"))
    }
}