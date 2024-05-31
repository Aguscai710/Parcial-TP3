package com.example.parcial.ui.offers

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.example.parcial.R

class OffersFragment : Fragment() {

    companion object {
        fun newInstance() = OffersFragment()
    }
    private var isFavorite = false

    private val viewModel: OffersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val view = inflater.inflate(R.layout.fragment_offers, container, false)

        val favoriteButton = view.findViewById<ImageButton>(R.id.favorite_button1)
        val favoriteButton2 = view.findViewById<ImageButton>(R.id.favorite_button2)



        favoriteButton.setOnClickListener{
            isFavorite = !isFavorite

            // Actualizar la apariencia del botón según el estado
            if (isFavorite) {
                favoriteButton.setImageResource(R.drawable.baseline_favorite_border_24)
            } else {
                favoriteButton.setImageResource(R.drawable.baseline_favorite_24)
            }
        }
        favoriteButton2.setOnClickListener{
            isFavorite = !isFavorite

            // Actualizar la apariencia del botón según el estado
            if (isFavorite) {
                favoriteButton2.setImageResource(R.drawable.baseline_favorite_border_24)
            } else {
                favoriteButton2.setImageResource(R.drawable.baseline_favorite_24)
            }
        }




        return view
    }

}