package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.MqMessage
import com.cyb3rko.m3okotlin.data.MqPublishRequest
import com.cyb3rko.m3okotlin.data.MqSubscribeRequest
import com.cyb3rko.m3okotlin.data.MqSubscribeResponse
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "mq"

/**
 * **PubSub messaging**
 *
 * A simple message broker which lets you publish and subscribe to messages with
 * no overhead. Use fire-and-forget semantics, if the subscriber is available
 * the message is received otherwise its dropped.
 *
 * @since 0.1.0
 */
object MqService {

    /**
     * Publish a message. Specify a topic to group messages for a specific
     * topic.
     * @since 0.1.0
     */
    suspend fun publish(message: MqMessage, topic: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Publish")) {
            body = MqPublishRequest(message, topic)
        }
    }

    /**
     * Subscribe to messages for a given topic.
     * @since 0.1.0
     */
    fun subscribe(
        topic: String,
        action: (Exception?, MqSubscribeResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Subscribe", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(MqSubscribeRequest(topic))
        ) { e, response ->
            action(
                e,
                if (response != null) Json.decodeFromString(response) else null
            )
        }
        socket.connect()
        return socket
    }
}
