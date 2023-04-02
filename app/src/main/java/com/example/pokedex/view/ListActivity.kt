package com.example.pokedex.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        initUI()
    }

    private fun initUI() {
        binding.pokelistRecyclerView.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter{
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        binding.pokelistRecyclerView.adapter = listAdapter
        viewModel.getPokemonList()
        viewModel.pokemonList.observe(this) { list ->
            listAdapter.setData(list)
        }
    }
}