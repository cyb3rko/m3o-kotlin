package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AvatarRequest
import com.cyb3rko.m3okotlin.data.AvatarResponse
import io.ktor.client.request.*

private const val SERVICE = "avatar"

object AvatarService {

    suspend fun generate(
        format: String = "",
        gender: String = "",
        upload: Boolean = false,
        username: String = ""
    ): AvatarResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = AvatarRequest(format, gender, upload, username)
        }
    }
}