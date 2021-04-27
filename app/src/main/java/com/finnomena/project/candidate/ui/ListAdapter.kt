package com.finnomena.project.candidate.ui

import android.annotation.SuppressLint
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

class ListAdapter(val context: Context) : RecyclerView.Adapter<ListAdapter.ListResultViewHolder>() {

    var listData: List<PokemonEntry> by Delegates.observable(listOf()) { _, _, _ -> notifyDataSetChanged() }

    lateinit var clickListener: (item: PokemonEntry) -> Unit
    private var focusPosition : Int? = null

    override fun getItemCount(): Int {
        return listData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListResultViewHolder, position: Int) {
        val item = listData[position]
        item.pokemonSpecies?.name?.let { holder.tvPokemonName.text = it }
        item.entryNumber?.let { holder.tvNumber.text = "#$it" }
        holder.layoutPokemon.setOnClickListener {
            clickListener.invoke(item)
        }
        focusPosition?.let{
            if (position==focusPosition){
                holder.tvPokemonName.setTextColor(context.getColor(R.color.colorPrimary))
                holder.tvNumber.setTextColor(context.getColor(R.color.colorPrimary))
            } else {
                holder.tvPokemonName.setTextColor(context.getColor(R.color.colorDarkGray))
                holder.tvNumber.setTextColor(context.getColor(R.color.colorDarkGray))
            }
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

    fun focusPosition(position: Int){
        focusPosition = position
    }

}