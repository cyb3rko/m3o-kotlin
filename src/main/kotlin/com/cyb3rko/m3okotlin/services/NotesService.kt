package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.WebSocket
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val SERVICE = "notes"

object NotesService {

    suspend fun create(text: String, title: String): NotesCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = NotesCreateRequest(text, title)
        }
    }

    suspend fun delete(id: String): NotesDeleteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = NotesDeleteRequest(id)
        }
    }

    fun events(id: String = "", action: (Exception?, NotesEventsResponse?) -> Unit): WebSocket {
        val url = M3O.getUrl(SERVICE, "Events", true)
        val socket = WebSocket(url, Json.encodeToString(NotesEventsRequest(id))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }
        socket.connect()
        return socket
    }

    suspend fun list(): NotesListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun read(id: String): NotesReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = NotesReadRequest(id)
        }
    }

    suspend fun update(note: NotesUpdate): NotesUpdateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = NotesUpdateRequest(note)
        }
    }
}
