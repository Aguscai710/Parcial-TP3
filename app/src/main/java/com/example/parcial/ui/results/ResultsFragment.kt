package com.example.parcial.ui.results

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial.R
import com.example.parcial.adapters.FlightAdapter
import com.example.parcial.databinding.FragmentResultsBinding
import com.example.parcial.model.FlightResponse

class ResultsFragment : Fragment() {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val flights: List<FlightResponse> = arguments?.getParcelableArrayList<FlightResponse>("flights") ?: emptyList()

        val flightAdapter = FlightAdapter(flights)
        binding.recyclerView.adapter = flightAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}