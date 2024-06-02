package com.example.parcial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial.model.FlightResponse
import com.example.parcial.holders.FlightHolder
import com.example.parcial.R
import com.example.parcial.data.model.Flight
import com.example.parcial.databinding.FragmentItemResultsBinding

class FlightAdapter(private var flights: List<Flight>) : RecyclerView.Adapter<FlightHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val vista =
        LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_results, parent, false)
        return FlightHolder(vista)
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        val flight = flights[position]

        holder.airline.text = flight.airline
        holder.duration.text = flight.duration.toString()
        holder.departureAirport.text = flight.departure_airport.id
        holder.arrivalAirport.text = flight.arrival_airport.id
        holder.travelClass.text = flight.travel_class
        Glide.with(holder.itemView.context).load(flight.airline_logo).into(holder.airlineLogo)
    }


    override fun getItemCount(): Int = flights.size

    fun updateFlights(newFlights: List<Flight>) {
        flights = newFlights
        notifyDataSetChanged()
    }

}
