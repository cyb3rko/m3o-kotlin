package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.HelloWorldCallRequest
import com.cyb3rko.m3okotlin.data.HelloWorldCallResponse
import com.cyb3rko.m3okotlin.data.HelloWorldStreamRequest
import com.cyb3rko.m3okotlin.data.HelloWorldStreamResponse
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "helloworld"

/**
 * **Just saying hello world**
 *
 * Helloworld simply returns a personalized message in response to a name. Use
 * it for testing purposes.
 *
 * @since 0.1.0
 */
object HelloWorldService {

    /**
     * Return a personalised Hello message
     * @since 0.1.0
     */
    suspend fun call(name: String): HelloWorldCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = HelloWorldCallRequest(name)
        }
    }

    /**
     * Stream a personalised Hello message
     * @since 0.1.0
     */
    fun stream(name: String, messages: Int = 1, action: (Exception?, HelloWorldStreamResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Stream", true)
        WebSocket(url, Json.encodeToString(HelloWorldStreamRequest(messages, name))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
}
