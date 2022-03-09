package com.cyb3rko.m3okotlin

import com.cyb3rko.m3okotlin.M3O.authorization
import java.lang.Exception
import java.net.URI
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake

class WebSocket(
    serverUrl: String,
    private val content: String = "",
    private val action: (Exception?, String?) -> Unit
): WebSocketClient(URI(serverUrl), mapOf(authorization)) {
    override fun onOpen(handshake: ServerHandshake?) {
        if (content.isNotBlank()) {
            send(content)
            Log.i("WebSocket opened, request sent.")
        } else {
            Log.i("WebSocket opened.")
        }
    }

    override fun onMessage(message: String?) {
        action(null, message.toString())
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        Log.i("WebSocket closed: $code (Closed by remote: $remote)")
    }

    override fun onError(e: Exception?) {
        action(e, null)
        Log.e("WebSocket received error: ${e.toString()}")
    }
}