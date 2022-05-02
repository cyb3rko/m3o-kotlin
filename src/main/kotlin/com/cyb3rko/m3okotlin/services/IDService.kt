package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IDGenerateRequest
import com.cyb3rko.m3okotlin.data.IDGenerateResponse
import com.cyb3rko.m3okotlin.data.IDTypesResponse
import io.ktor.client.request.*

private const val SERVICE = "id"

object IDService {

    suspend fun generate(type: String = "uuid"): IDGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = IDGenerateRequest(type)
        }
    }

    suspend fun types(): IDTypesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Types"))
    }
}