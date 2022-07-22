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
    val userIds: List<String>
)

@Serializable
data class ChatCreateResponse(val group: ChatGroup)

@Serializable
internal data class ChatDeleteRequest(@SerialName("group_id") val groupId: String)

@Serializable
data class ChatDeleteResponse(val group: ChatGroup)

@Serializable
internal data class ChatHistoryRequest(@SerialName("group_id") val groupId: String)

@Serializable
data class ChatHistoryResponse(val messages: List<ChatMessage>)

@Serializable
internal data class ChatInviteRequest(
    @SerialName("group_id")
    val groupId: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatInviteResponse(val group: ChatGroup)

@Serializable
internal data class ChatJoinRequest(
    @SerialName("group_id")
    val groupId: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatJoinResponse(val message: ChatMessage)

@Serializable
internal data class ChatKickRequest(
    @SerialName("group_id")
    val groupId: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatKickResponse(val group: ChatGroup)

@Serializable
internal data class ChatLeaveRequest(
    @SerialName("group_id")
    val groupId: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatLeaveResponse(val group: ChatGroup)

@Serializable
internal data class ChatListRequest(@SerialName("user_id") val userId: String)

@Serializable
data class ChatListResponse(val groups: List<ChatGroup>)

@Serializable
internal data class ChatSendRequest(
    val client: String,
    @SerialName("group_id")
    val groupId: String,
    val subject: String,
    val text: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatSendResponse(val message: ChatMessage)

// Data (multiple use)

@Serializable
data class ChatMessage(
    val client: String,
    val id: String,
    @SerialName("group_id")
    val groupId: String,
    @SerialName("sent_at")
    val sentAt: String,
    val subject: String,
    val text: String,
    @SerialName("user_id")
    val userId: String
)

@Serializable
data class ChatGroup(
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val id: String,
    val name: String,
    val private: Boolean,
    @SerialName("user_ids")
    val userIds: List<String>
)
