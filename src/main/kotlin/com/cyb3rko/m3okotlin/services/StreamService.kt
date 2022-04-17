package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "stream"

object StreamService {

    suspend fun createChannel(description: String, name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "CreateChannel")) {
            body = StreamCreateChannelRequest(description, name)
        }
    }

    suspend fun listChannels(): StreamListChannelsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListChannels"))
    }

    suspend fun listMessages(channel: String, limit: Int = 25): StreamListMessagesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListMessages")) {
            body = StreamListMessagesRequest(channel, limit)
        }
    }

    suspend fun sendMessage(channel: String, text: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "SendMessage")) {
            body = StreamSendMessageRequest(channel, text)
        }
    }
}