package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MinecraftRequest(val address: String)

@Serializable
data class MinecraftResponse(
    val favicon: String,
    val latency: Int,
    @SerialName("max_players")
    val maxPlayers: Int,
    val motd: String,
    val players: Int,
    val protocol: Int,
    val sample: List<Player>
) {

    @Serializable
    data class Player(val name: String, val uuid: String)
}
