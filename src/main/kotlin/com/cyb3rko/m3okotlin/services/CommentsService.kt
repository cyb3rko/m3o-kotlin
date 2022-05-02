package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "comments"

/**
 * **Add comments to any App**
 *
 * Add comments and replies to any app. Simple CRUD based storage to build a
 * comments feed anywhere on the web.
 *
 * @since 0.1.0
 */
object CommentsService {

    /**
     * Create a new comment
     * @since 0.1.0
     */
    suspend fun create(subject: String, text: String): CommentsCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = CommentsCreateRequest(subject, text)
        }
    }

    /**
     * Delete a comment
     * @since 0.1.0
     */
    suspend fun delete(id: String): CommentsDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = CommentsDeleteRequest(id)
        }
    }

    /**
     * Subscribe to comments events
     * @since 0.1.0
     */
    fun events(
        id: String = "",
        action: (Exception?, CommentsEventsResponse?) -> Unit
    ): WebSocket {
        val url = M3O.getUrl(SERVICE, "Events", true)
        val socket = WebSocket(
            url,
            Json.encodeToString(CommentsEventsRequest(id))
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
     * List all the comments
     * @since 0.1.0
     */
    suspend fun list(): CommentsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Read a comment
     * @since 0.1.0
     */
    suspend fun read(id: String): CommentsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = CommentsReadRequest(id)
        }
    }

    /**
     * Update a comment
     * @since 0.1.0
     */
    suspend fun update(comment: CommentsUpdate): CommentsUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = CommentsUpdateRequest(comment)
        }
    }
}
