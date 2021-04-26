package com.finnomena.project.candidate.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

import android.content.Context
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.finnomena.project.candidate.R
import com.finnomena.project.candidate.repositiry.model.PokemonEntry

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ListResultViewHolder>() {

    var listData: List<PokemonEntry> by Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    lateinit var clickListener: (item: PokemonEntry) -> Unit

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ListResultViewHolder, position: Int) {
        val item = listData[position]
        item.pokemonSpecies?.name?.let { holder.tvPokemonName.text = it }
        item.entryNumber?.let { holder.tvNumber.text = it.toString() }
        holder.layoutPokemon.setOnClickListener {
            clickListener.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list, parent, false)
        return ListResultViewHolder(view, this)
    }

    inner class ListResultViewHolder(itemView: View, private val adapter: ListAdapter) :
        RecyclerView.ViewHolder(itemView) {
        internal val tvPokemonName: TextView = itemView.findViewById(R.id.tvPokemonName)
        internal val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
        internal val layoutPokemon: ConstraintLayout = itemView.findViewById(R.id.layoutPokemon)
    }

}