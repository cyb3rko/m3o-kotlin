package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AddressRequest(val postcode: String)

@Serializable
data class AddressResponse(val addresses: List<Addresses>) {

    @Serializable
    data class Addresses(
        @SerialName("line_one")
        val lineOne: String,
        @SerialName("line_two")
        val lineTwo: String,
        val summary: String,
        val organisation: String,
        @SerialName("building_name")
        val buildingName: String,
        val premise: String,
        val street: String,
        val locality: String,
        val town: String,
        val county: String,
        val postcode: String
    )
}