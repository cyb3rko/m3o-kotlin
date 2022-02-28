package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.EmojiFindRequest
import com.cyb3rko.m3okotlin.data.EmojiFlagRequest
import io.ktor.client.request.*

private const val SERVICE = "emoji"

object EmojiService {

    suspend fun find(alias: String): EmojiFindResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Find")) {
            body = EmojiFindRequest(alias)
        }
    }

    suspend fun flag(code: String): EmojiFlagResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Flag")) {
            body = EmojiFlagRequest(code)
        }
    }

    suspend fun print(text: String): EmojiPrintResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Print")) {
            body = EmojiPrintRequest(text)
        }
    }
}