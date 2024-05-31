package com.example.parcial.ui.explore

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.databinding.FragmentExploreBinding
import com.example.parcial.ui.Adapters.DestinationsExploreAdapter
import com.example.parcial.ui.Entidades.DestinosExplore
import com.example.parcial.R

class ExploreFragment : Fragment() {


    private lateinit var DestinosRecyclerView: RecyclerView
    private lateinit var DestinosAdapter: DestinationsExploreAdapter

    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ExploreFragment()
    }

    private val viewModel: ExploreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        DestinosRecyclerView = _binding!!.trendingDestinations
        DestinosRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        DestinosAdapter = DestinationsExploreAdapter(obtenerDestinos())
        DestinosRecyclerView.adapter = DestinosAdapter




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun obtenerDestinos(): List<DestinosExplore> {
        return listOf(
            DestinosExplore("Boracay", "Philippines", "5D4N", R.drawable.boracay),
            DestinosExplore("Baros", "Maldives", "7D6N", R.drawable.baros),
            DestinosExplore("Bali", "Indonesia", "3D2N", R.drawable.bali),
            DestinosExplore("Palawan", "Philippines", "3D2N", R.drawable.palawan)
        )
    }
}