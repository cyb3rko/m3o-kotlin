package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "app"

/**
 * **Serverless app deployment**
 *
 * Deploy serverless apps and services from source. Supports multiple regions
 * and provides a custom HTTPS URL.
 *
 * @since 0.1.0
 */
object AppsService {

    /**
     * Delete an app
     * @since 0.1.0
     */
    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = AppsDeleteRequest(name)
        }
    }

    /**
     * List all the apps
     * @since 0.1.0
     */
    suspend fun list(): AppsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Get the logs for an app
     * @since 0.1.0
     */
    suspend fun logs(logsType: String, name: String): AppsLogsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logs")) {
            body = AppsLogsRequest(logsType, name)
        }
    }

    /**
     * Return the support regions
     * @since 0.1.0
     */
    suspend fun regions(): AppsRegionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Regions"))
    }

    /**
     * Reserve apps beyond the free quota. Call Run after.
     * @since 0.1.0
     */
    suspend fun reserve(name: String): AppsReserveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reserve")) {
            body = AppsReserveRequest(name)
        }
    }

    /**
     * Resolve an app by id to its raw backend endpoint
     * @since 0.1.0
     */
    suspend fun resolve(id: String): AppsResolveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Resolve")) {
            body = AppsResolveRequest(id)
        }
    }

    /**
     * Run an app from source
     * @since 0.1.0
     */
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

    /**
     * Get the status of an app
     * @since 0.2.3
     */
    suspend fun status(name: String): AppsStatusResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Status")) {
            body = AppsStatusRequest(name)
        }
    }

    /**
     * Update the app. The latest source code will be downloaded, built and
     * deployed.
     * @since 0.2.3
     */
    suspend fun update(name: String, envVars: Map<String, String> = mapOf()) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = AppsUpdateRequest(envVars, name)
        }
    }

    suspend fun App.delete() = delete(this.name)

    suspend fun App.logs(logsType: String) = logs(logsType, this.name)

    suspend fun App.resolve() = resolve(this.id)

    suspend fun App.run(
        port: Int,
        region: String,
        repo: String,
        branch: String = "",
        envVars: Map<String, String> = mapOf()
    ) = run(
        this.name,
        port,
        region,
        repo,
        branch,
        envVars
    )

    suspend fun App.status() = status(this.name)

    suspend fun App.update(envVars: Map<String, String>) = update(this.name, envVars)
}
