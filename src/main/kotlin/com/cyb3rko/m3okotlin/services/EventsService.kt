package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "event"

object EventsService {

    fun consume(
        topic: String,
        group: String = "",
        offset: String = "",
        action: (Exception?, EventsConsumeResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Consume", true)
        val socket = WebSocket(url, Json.encodeToString(EventsConsumeRequest(group, offset, topic))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }
        socket.connect()
        return socket
    }

    suspend fun publish(message: EventsMessage, topic: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Publish")) {
            body = EventsPublishRequest(message, topic)
        }
    }

    suspend fun read(
        topic: String,
        limit: Int = 0,
        offset: Int = 0
    ): EventsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = EventsReadRequest(limit, offset, topic)
        }
    }
}
