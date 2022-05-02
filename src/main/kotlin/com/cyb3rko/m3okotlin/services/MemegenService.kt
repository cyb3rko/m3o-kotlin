package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.MemegenGenerateRequest
import com.cyb3rko.m3okotlin.data.MemegenGenerateResponse
import com.cyb3rko.m3okotlin.data.MemegenTemplatesResponse
import com.cyb3rko.m3okotlin.data.MemegenTemplatesResponse.MemegenTemplatesEntry
import io.ktor.client.request.*

private const val SERVICE = "memegen"

/**
 * **Generate funny memes**
 *
 * Generate memes. That's it.
 *
 * @since 0.1.0
 */
object MemegenService {

    /**
     * Generate a meme using a template
     * @since 0.1.0
     */
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

    /**
     * List the available templates
     * @since 0.1.0
     */
    suspend fun templates(): MemegenTemplatesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Templates"))
    }

    suspend fun MemegenTemplatesEntry.generate(
        bottomText: String,
        topText: String,
        font: String = "impact",
        maxFontSize: String = "50px"
    ) = generate(bottomText, this.id, topText, font, maxFontSize)
}
