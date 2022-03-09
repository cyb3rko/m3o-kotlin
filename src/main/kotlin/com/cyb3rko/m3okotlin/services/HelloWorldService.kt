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

object HelloWorldService {

    suspend fun call(name: String): HelloWorldCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = HelloWorldCallRequest(name)
        }
    }

    fun stream(name: String, messages: Int = 1, action: (Exception?, HelloWorldStreamResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Stream", true)
        WebSocket(url, Json.encodeToString(HelloWorldStreamRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
}