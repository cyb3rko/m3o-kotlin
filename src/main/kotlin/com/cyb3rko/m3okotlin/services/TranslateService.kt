package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.TranslateRequest
import com.cyb3rko.m3okotlin.data.TranslateResponse
import io.ktor.client.request.*

private const val SERVICE = "translate"

/**
 * **Language translation service**
 *
 * Translate basic text from any language. A simple API powered by Google
 * Translate.
 *
 * @since 0.1.0
 */
object TranslateService {

    /**
     * Basic text translation
     * @since 0.1.0
     */
    suspend fun text(
        content: String,
        source: String,
        target: String,
        format: String = "text",
        model: String = "nmt"
    ): TranslateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Text")) {
            body = TranslateRequest(content, format, model, source, target)
        }
    }
}
