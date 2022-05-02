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
        userIDs: List<String> = listOf()
    ): ChatCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = ChatCreateRequest(description, name, private, userIDs)
        }
    }

    /**
     * Delete a chat room
     * @since 0.1.0
     */
    suspend fun delete(roomID: String): ChatDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = ChatDeleteRequest(roomID)
        }
    }

    /**
     * List the messages in a chat
     * @since 0.1.0
     */
    suspend fun history(roomID: String): ChatHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = ChatHistoryRequest(roomID)
        }
    }

    /**
     * Invite a user to a chat room
     * @since 0.1.0
     */
    suspend fun invite(roomID: String, userID: String): ChatInviteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Invite")) {
            body = ChatInviteRequest(roomID, userID)
        }
    }

    /**
     * Join a chat room
     * @since 0.1.0
     */
    fun join(
        roomID: String,
        userID: String,
        action: (Exception?, ChatJoinResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Join", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(ChatJoinRequest(roomID, userID))
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
    suspend fun kick(roomID: String, userID: String): ChatKickResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Kick")) {
            body = ChatKickRequest(roomID, userID)
        }
    }

    /**
     * Leave a chat room
     * @since 0.1.0
     */
    suspend fun leave(roomID: String, userID: String): ChatLeaveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Leave")) {
            body = ChatLeaveRequest(roomID, userID)
        }
    }

    /**
     * List available chats
     * @since 0.1.0
     */
    suspend fun list(userID: String = ""): ChatListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = ChatListRequest(userID)
        }
    }

    /**
     * Connect to a chat to receive a stream of messages Send a message to a
     * chat
     * @since 0.1.0
     */
    suspend fun send(
        client: String,
        roomID: String,
        subject: String,
        text: String,
        userID: String,
    ): ChatSendResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Send")) {
            body = ChatSendRequest(client, roomID, subject, text, userID)
        }
    }
}
