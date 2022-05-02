package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.PasswordsRequest
import com.cyb3rko.m3okotlin.data.PasswordsResponse
import io.ktor.client.request.*

private const val SERVICE = "password"

/**
 * **Generate strong passwords**
 *
 * Generate strong passwords used for signing up to services. Optionally specify
 * length, whether to include numbers, symbols and upper or lowercase
 * characters.
 *
 * @since 0.1.0
 */
object PasswordsService {

    suspend fun generate(
        length: Int = 8,
        lowercase: Boolean = true,
        numbers: Boolean = true,
        special: Boolean = true,
        uppercase: Boolean = true
    ): PasswordsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Generate")) {
            body = PasswordsRequest(length, lowercase, numbers, special, uppercase)
        }
    }
}
