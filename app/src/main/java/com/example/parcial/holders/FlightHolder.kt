package com.example.parcial.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcial.data.model.Flight
import com.example.parcial.databinding.FragmentItemResultsBinding


class FlightHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    (private val binding: FragmentItemResultsBinding) :
//    RecyclerView.ViewHolder(binding.root) {

    private var _binding: FragmentItemResultsBinding? = null
    private val binding get() = _binding!!


    val airline: TextView = binding.txtAirlineName
    val duration: TextView = binding.txtDuration
    val departureAirport: TextView = binding.txtDepartureAirport
    val arrivalAirport: TextView = binding.txtArrivalAirport
    val travelClass: TextView = binding.tvClass
    val airlineLogo: ImageView = binding.ivAirlineLogo


//    fun render(model: Flight) {
//        binding.txtAirlineName: TextView = model.airline
//        binding.txtDuration: TextView = model.duration
//        binding.txtDepartureAirport = model.departure_airport
//        binding.txtArrivalAirport = model.arrival_airport
//        binding.tvClass = model.travel_class
//        Glide.with(binding.ivAirlineLogo.context).load(model.airline_logo).into(binding.ivAirlineLogo)
//    }

}