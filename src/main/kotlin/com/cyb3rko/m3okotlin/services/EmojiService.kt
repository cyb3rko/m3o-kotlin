package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "emoji"

/**
 * **All the emojis you need 🎉**
 *
 * Get your emoji fix. Find by alias, print text and fly high with your
 * country's flag.
 *
 * @since 0.1.0
 */
object EmojiService {

    /**
     * Find an emoji by its alias e.g :beer:
     * @since 0.1.0
     */
    suspend fun find(alias: String): EmojiFindResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Find")) {
            body = EmojiFindRequest(alias)
        }
    }

    /**
     * Get the flag for a country. Requires country code e.g GB for great
     * britain
     * @since 0.1.0
     */
    suspend fun flag(code: String): EmojiFlagResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Flag")) {
            body = EmojiFlagRequest(code)
        }
    }

    /**
     * Print text and renders the emojis with aliases e.g let's grab a :beer:
     * becomes let's grab a 🍺
     * @since 0.1.0
     */
    suspend fun print(text: String): EmojiPrintResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Print")) {
            body = EmojiPrintRequest(text)
        }
    }
}
