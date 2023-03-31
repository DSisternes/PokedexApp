package com.example.pokedex.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.ApiService
import com.example.pokedex.model.ApiResponse
import com.example.pokedex.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel() : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ApiService = retrofit.create(ApiService::class.java)

    val pokemonList = MutableLiveData<List<Result>>()

    fun getPokemonList(){
        val call = service.getPokemonList(1118,0)

        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                response.body()?.results?.let { list ->
                    pokemonList.postValue(list)
                }

            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                call.cancel()
            }

        })
    }
}