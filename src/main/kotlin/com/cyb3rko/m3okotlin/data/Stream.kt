package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class StreamCreateChannelRequest(val description: String, val name: String)

@Serializable
data class StreamListChannelsResponse(val channels: List<StreamChannel>) {

    @Serializable
    data class StreamChannel(
        val name: String,
        val description: String,
        @SerialName("last_active")
        val lastActive: String
    )
}

@Serializable
internal data class StreamListMessagesRequest(val channel: String, val limit: Int)

@Serializable
data class StreamListMessagesResponse(val channel: String, val messages: List<StreamMessage>) {

    @Serializable
    data class StreamMessage(
        val id: String,
        val text: String,
        val timestamp: String,
        val channel: String,
        val metadata: Map<String, String>
    )
}

@Serializable
internal data class StreamSendMessageRequest(val channel: String, val text: String)