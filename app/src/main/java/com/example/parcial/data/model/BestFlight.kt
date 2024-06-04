package com.example.parcial.data.model

data class BestFlight(
    val airline_logo: String,
    val departure_token: String,
    val flights: List<Flight>,
    val price: Int,
    val total_duration: Int,
    val type: String
)