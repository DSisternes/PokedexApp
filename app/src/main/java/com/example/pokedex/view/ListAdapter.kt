package com.example.pokedex.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.ActivityListBinding
import com.example.pokedex.model.Result

class ListAdapter(private val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<ListAdapter.SearchViewHolder>() {
    private var pokemonList: List<Result> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Result>) {
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ActivityListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val binding = holder.binding
        val pokemon = pokemonList[position]

        binding.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1)
        }
    }
    class SearchViewHolder(val binding: ActivityListBinding): RecyclerView.ViewHolder(binding.root)
}