package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IdGenerateRequest
import com.cyb3rko.m3okotlin.data.IdGenerateResponse
import com.cyb3rko.m3okotlin.data.IdTypesResponse
import io.ktor.client.request.*

private const val SERVICE = "id"

/**
 * **Generate unique IDs (uuid, snowflake, etc)**
 *
 * The ID service provides unique ID generation. Including UUID, snowflake
 * (64 bit) and bigflake (128 bit)
 *
 * @since 0.1.0
 */
object IdService {

    /**
     * Generate a unique ID. Defaults to uuid.
     * @since 0.1.0
     */
    suspend fun generate(type: String = "uuid"): IdGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
            body = IdGenerateRequest(type)
        }
    }

    /**
     * List the types of IDs available. No query params needed.
     * @since 0.1.0
     */
    suspend fun types(): IdTypesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Types"))
    }
}
