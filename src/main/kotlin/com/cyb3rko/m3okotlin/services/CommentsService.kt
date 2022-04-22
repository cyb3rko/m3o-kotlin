package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "comments"

object CommentsService {

    suspend fun create(subject: String, text: String): CommentsCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = CommentsCreateRequest(subject, text)
        }
    }

    suspend fun delete(id: String): CommentsDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = CommentsDeleteRequest(id)
        }
    }

    fun events(id: String = "", action: (Exception?, CommentsEventsResponse?) -> Unit): WebSocket {
        val url = M3O.getUrl(SERVICE, "Events", true)
        val socket = WebSocket(url, Json.encodeToString(CommentsEventsRequest(id))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }
        socket.connect()
        return socket
    }

    suspend fun list(): CommentsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun read(id: String): CommentsReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = CommentsReadRequest(id)
        }
    }

    suspend fun update(comment: CommentsUpdate): CommentsUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = CommentsUpdateRequest(comment)
        }
    }
}
