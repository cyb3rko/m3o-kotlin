package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "event"

/**
 * **Event stream processing**
 *
 * Publish and consume messages from a scalable persistent event stream. Group
 * messages by topic and asynchronously notify listeners of new events occuring
 * in real time. Messages are persisted in case consumers disconnect.
 *
 * @since 0.1.0
 */
object EventsService {

    /**
     * Consume events from a given topic.
     * @since 0.1.0
     */
    fun consume(
        topic: String,
        group: String = "",
        offset: String = "",
        action: (Exception?, EventsConsumeResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Consume", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(EventsConsumeRequest(group, offset, topic))
        ) { e, response ->
            action(
                e,
                if (response != null) Json.decodeFromString(response) else null
            )
        }
        socket.connect()
        return socket
    }

    /**
     * Publish a event to the event stream.
     * @since 0.1.0
     */
    suspend fun publish(message: EventsMessage, topic: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Publish")) {
            body = EventsPublishRequest(message, topic)
        }
    }

    /**
     * Read stored events
     * @since 0.1.0
     */
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
