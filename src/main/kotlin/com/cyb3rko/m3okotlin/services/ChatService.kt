package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "chat"

/**
 * **Real time messaging**
 *
 * The Chat service is a programmable instant messaging API service which can
 * be used in any application to immediately create conversations.
 *
 * @since 0.1.0
 */
object ChatService {

    /**
     * Create a new chat room
     * @since 0.1.0
     */
    suspend fun create(
        description: String,
        name: String,
        private: Boolean = false,
        userIds: List<String> = listOf()
    ): ChatCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = ChatCreateRequest(description, name, private, userIds)
        }
    }

    /**
     * Delete a chat room
     * @since 0.1.0
     */
    suspend fun delete(groupId: String): ChatDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ChatDeleteRequest(groupId)
        }
    }

    /**
     * List the messages in a chat
     * @since 0.1.0
     */
    suspend fun history(groupId: String): ChatHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = ChatHistoryRequest(groupId)
        }
    }

    /**
     * Invite a user to a chat room
     * @since 0.1.0
     */
    suspend fun invite(groupId: String, userId: String): ChatInviteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Invite")) {
            body = ChatInviteRequest(groupId, userId)
        }
    }

    /**
     * Join a chat room
     * @since 0.1.0
     */
    fun join(
        groupId: String,
        userId: String,
        action: (Exception?, ChatJoinResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Join", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(ChatJoinRequest(groupId, userId))
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
     * Kick a user from a chat room
     * @since 0.1.0
     */
    suspend fun kick(groupId: String, userId: String): ChatKickResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Kick")) {
            body = ChatKickRequest(groupId, userId)
        }
    }

    /**
     * Leave a chat room
     * @since 0.1.0
     */
    suspend fun leave(groupId: String, userId: String): ChatLeaveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Leave")) {
            body = ChatLeaveRequest(groupId, userId)
        }
    }

    /**
     * List available chats
     * @since 0.1.0
     */
    suspend fun list(userId: String = ""): ChatListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = ChatListRequest(userId)
        }
    }

    /**
     * Connect to a chat to receive a stream of messages Send a message to a
     * chat
     * @since 0.1.0
     */
    suspend fun send(
        client: String,
        groupId: String,
        subject: String,
        text: String,
        userId: String
    ): ChatSendResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Send")) {
            body = ChatSendRequest(client, groupId, subject, text, userId)
        }
    }

    suspend fun ChatGroup.delete() = delete(this.id)

    suspend fun ChatGroup.history() = history(this.id)

    suspend fun ChatGroup.invite(userId: String) = invite(this.id, userId)

    fun ChatGroup.join(userId: String, action: (Exception?, ChatJoinResponse?) -> Unit) = join(
        this.id, userId, action
    )

    suspend fun ChatGroup.kick(userId: String) = kick(this.id, userId)

    suspend fun ChatGroup.leave(userId: String) = leave(this.id, userId)

    suspend fun ChatGroup.send(
        client: String,
        subject: String,
        text: String,
        userId: String
    ) = send(client, this.id, subject, text, userId)
}
