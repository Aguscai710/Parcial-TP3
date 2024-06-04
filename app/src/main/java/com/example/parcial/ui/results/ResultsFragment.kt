package com.example.parcial.ui.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.adapters.FlightAdapter
import com.example.parcial.data.model.Flight
import com.example.parcial.data.remote.RetrofitClient
import com.example.parcial.databinding.FragmentResultsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ResultsFragment : Fragment() {

    private lateinit var flightAdapter: FlightAdapter
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewResults
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        flightAdapter = FlightAdapter(emptyList())
        recyclerView.adapter = flightAdapter

        fetchFlights()

        return binding.root
    }

    private fun fetchFlights() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getFlights()
                val flights = response.best_flights.map { bestFlight ->
                    bestFlight.flights.firstOrNull()?.let { flight ->
                        Flight(
                            airline = flight.airline,
                            duration = flight.duration,
                            departure_airport = flight.departure_airport,
                            arrival_airport = flight.arrival_airport,
                            travel_class = flight.travel_class,
                            airline_logo = flight.airline_logo,
                            airplane = flight.airplane,
                            extensions = flight.extensions,
                            flight_number = flight.flight_number,
                            legroom = flight.legroom,
                            often_delayed_by_over_30_min = flight.often_delayed_by_over_30_min,
                            overnight = flight.overnight,
                            price = bestFlight.price
                        )
                    }
                }.filterNotNull()

                withContext(Dispatchers.Main) {
                    flightAdapter.updateFlights(flights)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}