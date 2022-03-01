package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IDgenGenerateRequest
import com.cyb3rko.m3okotlin.data.IDgenGenerateResponse
import com.cyb3rko.m3okotlin.data.IDgenTypesResponse
import io.ktor.client.request.*

private const val SERVICE = "id"

object IDgenService {

    suspend fun generate(type: String = "uuid"): IDgenGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = IDgenGenerateRequest(type)
        }
    }

    suspend fun types(): IDgenTypesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Types"))
    }
}