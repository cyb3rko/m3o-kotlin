package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "db"

object DBService {

    suspend fun count(table: String = "default"): DBCountResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Count")) {
            body = DBCountRequest(table)
        }
    }

    suspend fun create(
        record: JsonObject,
        id: String = "",
        table: String = "default"
    ): DBCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = DBCreateRequest(id, record, table)
        }
    }

    suspend fun delete(id: String, table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = DBDeleteRequest(id, table)
        }
    }

    suspend fun dropTable(table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "DropTable")) {
            body = DBDropTableRequest(table)
        }
    }

    suspend fun listTables(): DBListTablesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListTables"))
    }

    suspend fun read(
        id: String = "",
        limit: Int = 0,
        offset: Int = 0,
        order: String = "asc",
        orderBy: String = "",
        query: String = "",
        table: String = "default"
    ): DBReadResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Read")) {
            body = DBReadRequest(id, limit, offset, order, orderBy, query, table)
        }
    }

    suspend fun renameTable(from: String, to: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "RenameTable")) {
            body = DBRenameTableRequest(from, to)
        }
    }

    suspend fun truncate(table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Truncate")) {
            body = DBTruncateRequest(table)
        }
    }

    suspend fun update(
        record: JsonObject,
        id: String = "",
        table: String = "default"
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = DBUpdateRequest(id, record, table)
        }
    }
}
