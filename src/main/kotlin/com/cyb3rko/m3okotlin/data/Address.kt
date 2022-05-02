package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class AddressRequest(val postcode: String)

@Serializable
data class AddressResponse(val addresses: List<Address>) {

    @Serializable
    data class Address(
        @SerialName("building_name")
        val buildingName: String,
        val county: String,
        @SerialName("line_one")
        val lineOne: String,
        @SerialName("line_two")
        val lineTwo: String,
        val locality: String,
        val organisation: String,
        val postcode: String,
        val premise: String,
        val street: String,
        val summary: String,
        val town: String
    )
}
