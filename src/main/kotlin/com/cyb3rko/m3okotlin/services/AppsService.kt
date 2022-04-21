package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "app"

object AppsService {

    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = AppsDeleteRequest(name)
        }
    }

    suspend fun list(): AppsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun logs(logsType: String, name: String): AppsLogsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logs")) {
            body = AppsLogsRequest(logsType, name)
        }
    }

    suspend fun regions(): AppsRegionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Regions"))
    }

    suspend fun reserve(name: String): AppsReserveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reserve")) {
            body = AppsReserveRequest(name)
        }
    }

    suspend fun resolve(id: String): AppsResolveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Resolve")) {
            body = AppsResolveRequest(id)
        }
    }

    suspend fun run(
        name: String,
        port: Int,
        region: String,
        repo: String,
        branch: String = "",
        envVars: Map<String, String> = mapOf(),
    ): AppsRunResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Run")) {
            body = AppsRunRequest(branch, envVars, name, port, region, repo)
        }
    }
}
