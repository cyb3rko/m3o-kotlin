package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class ChatCreateRequest(
    val description: String,
    val name: String,
    val private: Boolean,
    @SerialName("user_ids")
    val userIDs: List<String>
)

@Serializable
data class ChatCreateResponse(val room: ChatRoom)

@Serializable
internal data class ChatDeleteRequest(@SerialName("room_id") val roomID: String)

@Serializable
data class ChatDeleteResponse(val room: ChatRoom)

@Serializable
internal data class ChatHistoryRequest(@SerialName("room_id") val roomID: String)

@Serializable
data class ChatHistoryResponse(val messages: List<ChatMessage>)

@Serializable
internal data class ChatInviteRequest(
    @SerialName("room_id")
    val roomID: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatInviteResponse(val room: ChatRoom)

@Serializable
internal data class ChatJoinRequest(
    @SerialName("room_id")
    val roomID: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatJoinResponse(val message: ChatMessage)

@Serializable
internal data class ChatKickRequest(
    @SerialName("room_id")
    val roomID: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatKickResponse(val room: ChatRoom)

@Serializable
internal data class ChatLeaveRequest(
    @SerialName("room_id")
    val roomID: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatLeaveResponse(val room: ChatRoom)

@Serializable
internal data class ChatListRequest(@SerialName("user_id") val userID: String)

@Serializable
data class ChatListResponse(val rooms: List<ChatRoom>)

@Serializable
internal data class ChatSendRequest(
    val client: String,
    @SerialName("room_id")
    val roomID: String,
    val subject: String,
    val text: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatSendResponse(val message: ChatMessage)

// Data (multiple use)

@Serializable
data class ChatMessage(
    val client: String,
    val id: String,
    @SerialName("room_id")
    val roomID: String,
    @SerialName("sent_at")
    val sentAt: String,
    val subject: String,
    val text: String,
    @SerialName("user_id")
    val userID: String
)

@Serializable
data class ChatRoom(
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val id: String,
    val name: String,
    val private: Boolean,
    @SerialName("user_ids")
    val userIDs: List<String>
)
