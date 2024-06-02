package com.example.parcial.ui.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.parcial.R
import com.example.parcial.ui.search.SearchFragment

class ItemResultsFragment : Fragment() {

    lateinit var vista: View

    companion object {
        fun newInstance() = ItemResultsFragment()
    }

    private val viewModel: ItemResultsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    /*override fun onStart() {
        super.onStart()
        val classSelected: String = arguments?.getString("classSelected") ?: ""
        val tvClass: TextView = vista.findViewById(R.id.tvClass)
        tvClass.text = classSelected
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_results, container, false)
    }
}