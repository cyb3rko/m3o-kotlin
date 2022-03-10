package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class VehicleRequest(val registration: String)

@Serializable
data class VehicleResponse(
    @SerialName("co2_emissions")
    val co2Emissions: Int,
    val colour: String,
    @SerialName("engine_capacity")
    val engineCapacity: Int,
    @SerialName("fuel_type")
    val fuelType: String,
    @SerialName("last_v5_issued")
    val lastV5Issued: String,
    @SerialName("logo_url")
    val logoUrl: String,
    val make: String,
    @SerialName("month_of_first_registration")
    val MonthOfFirstRegistration: String,
    @SerialName("mot_expiry")
    val motExpiry: String,
    @SerialName("mot_status")
    val motStatus: String,
    val registration: String,
    @SerialName("tax_due_date")
    val taxDueDate: String,
    @SerialName("tax_status")
    val taxStatus: String,
    @SerialName("type_approval")
    val typeApproval: String,
    val wheelplan: String,
    @SerialName("year_of_manufacture")
    val yearOfManufacture: Int
)