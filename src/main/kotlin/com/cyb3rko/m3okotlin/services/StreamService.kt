package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.StreamListChannelsResponse.StreamChannel
import io.ktor.client.request.*

private const val SERVICE = "stream"

/**
 * **Ephemeral message streams**
 *
 * The stream service provides ephemeral message streams. Messages expire after
 * 24 hours. Streams are limited to 1000 messages and 1000 streams in total. Max
 * message size is 512 characters.
 *
 * @since 0.1.0
 */
object StreamService {

    /**
     * Create a channel by name
     * @since 0.1.0
     */
    suspend fun createChannel(description: String, name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "CreateChannel")) {
            body = StreamCreateChannelRequest(description, name)
        }
    }

    /**
     * List all the active channels
     * @since 0.1.0
     */
    suspend fun listChannels(): StreamListChannelsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListChannels"))
    }

    /**
     * List messages for a given channel
     * @since 0.1.0
     */
    suspend fun listMessages(channel: String, limit: Int = 25): StreamListMessagesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListMessages")) {
            body = StreamListMessagesRequest(channel, limit)
        }
    }

    /**
     * Send a message to the stream.
     * @since 0.1.0
     */
    suspend fun sendMessage(channel: String, text: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "SendMessage")) {
            body = StreamSendMessageRequest(channel, text)
        }
    }

    suspend fun StreamChannel.listMessages(limit: Int = 25) = listMessages(this.name, limit)

    suspend fun StreamChannel.sendMessage(text: String) = sendMessage(this.name, text)
}
