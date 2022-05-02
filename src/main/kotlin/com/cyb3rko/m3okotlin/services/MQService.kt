package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.MQMessage
import com.cyb3rko.m3okotlin.data.MQPublishRequest
import com.cyb3rko.m3okotlin.data.MQSubscribeRequest
import com.cyb3rko.m3okotlin.data.MQSubscribeResponse
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
object MQService {

    /**
     * Publish a message. Specify a topic to group messages for a specific
     * topic.
     * @since 0.1.0
     */
    suspend fun publish(message: MQMessage, topic: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Publish")) {
            body = MQPublishRequest(message, topic)
        }
    }

    /**
     * Subscribe to messages for a given topic.
     * @since 0.1.0
     */
    fun subscribe(topic: String, action: (Exception?, MQSubscribeResponse?) -> Unit): WebSocket {
        val url = M3O.getUrl(SERVICE, "Subscribe", true)
        val socket = WebSocket(url, Json.encodeToString(MQSubscribeRequest(topic))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }
        socket.connect()
        return socket
    }
}
