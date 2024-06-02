package com.example.parcial.data.model

data class FlightModel(
    val best_flights: List<BestFlight>,
    val other_flights: List<OtherFlight>,
    val price_insights: PriceInsights,
    val search_metadata: SearchMetadata,
    val search_parameters: SearchParameters
)