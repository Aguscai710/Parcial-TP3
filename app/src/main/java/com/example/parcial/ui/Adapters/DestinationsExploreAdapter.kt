package com.example.parcial.ui.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial.ui.Entidades.DestinosExplore
import com.example.parcial.R
class DestinationsExploreAdapter(private val destinations: List<DestinosExplore>) :
    RecyclerView.Adapter<DestinationsExploreAdapter.DestinationViewHolder>() {

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombre_explore)
        val lugarTextView: TextView = itemView.findViewById(R.id.lugar_explore)
        val duracionTextView: TextView = itemView.findViewById(R.id.duracion_explore)
        val imagenView: ImageView = itemView.findViewById(R.id.imagen_explore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.destinos_explore, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = destinations[position]
        holder.nombreTextView.text = destination.nombre
        holder.lugarTextView.text = destination.lugar
        holder.duracionTextView.text = destination.duracion
        holder.imagenView.setImageResource(destination.imagen)
    }

    override fun getItemCount(): Int {
        return destinations.size
    }
}