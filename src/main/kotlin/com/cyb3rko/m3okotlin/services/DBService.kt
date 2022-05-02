package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "db"

/**
 * **Serverless postgres database**
 *
 * Our Database service is an easy to use serverless postgres database which
 * provides persistent storage via a CRUD interface. It includes feature rich
 * querying and JSON based formatted records for native use in Node.js and or
 * any language.
 *
 * @since 0.1.0
 */
object DBService {

    /**
     * Count records in a table
     * @since 0.1.0
     */
    suspend fun count(table: String = "default"): DBCountResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Count")) {
            body = DBCountRequest(table)
        }
    }

    /**
     * Create a record in the database. Optionally include an "id" field
     * otherwise it's set automatically.
     * @since 0.1.0
     */
    suspend fun create(
        record: JsonObject,
        id: String = "",
        table: String = "default"
    ): DBCreateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Create")) {
            body = DBCreateRequest(id, record, table)
        }
    }

    /**
     * Delete a record in the database by id.
     * @since 0.1.0
     */
    suspend fun delete(id: String, table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = DBDeleteRequest(id, table)
        }
    }

    /**
     * Drop a table in the DB
     * @since 0.1.0
     */
    suspend fun dropTable(table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "DropTable")) {
            body = DBDropTableRequest(table)
        }
    }

    /**
     * List tables in the DB
     * @since 0.1.0
     */
    suspend fun listTables(): DBListTablesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ListTables"))
    }

    /**
     * Read data from a table. Lookup can be by ID or via querying any field in
     * the record.
     * @since 0.1.0
     */
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

    /**
     * Rename a table
     * @since 0.1.0
     */
    suspend fun renameTable(from: String, to: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "RenameTable")) {
            body = DBRenameTableRequest(from, to)
        }
    }

    /**
     * Truncate the records in a table
     * @since 0.1.0
     */
    suspend fun truncate(table: String = "default") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Truncate")) {
            body = DBTruncateRequest(table)
        }
    }

    /**
     * Update a record in the database. Include an "id" in the record to update.
     * @since 0.1.0
     */
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
