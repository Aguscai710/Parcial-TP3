package com.example.parcial.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.R
import com.example.parcial.databinding.FragmentItemResultsBinding


class FlightHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val airline: TextView = itemView.findViewById(R.id.txtAirlineName)
    val duration: TextView = itemView.findViewById(R.id.txtDuration)
    val departureAirport: TextView = itemView.findViewById(R.id.txtDepartureAirport)
    val departureAirportId: TextView = itemView.findViewById(R.id.txtDepartureAirportId)
    val arrivalAirport: TextView = itemView.findViewById(R.id.txtArrivalAirport)
    val arrivalAirportId: TextView = itemView.findViewById(R.id.txtArrivalAirportId)
    val travelClass: TextView = itemView.findViewById(R.id.tvClass)
    val price: TextView = itemView.findViewById(R.id.tvPrice)
    val airlineLogo: ImageView = itemView.findViewById(R.id.ivAirlineLogo)


}