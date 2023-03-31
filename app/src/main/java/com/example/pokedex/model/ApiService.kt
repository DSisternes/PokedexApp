package com.example.pokedex.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<ApiResponse>
    @GET("pokemon-species/{id}")
    fun getPokemonSpecies(@Path("id") id: Int): Call<Pokemon>
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: String): Pokemon
    @GET("pokemon/{id}")
    fun getPokemonEs( @Path("id") id: String, @Query("language") language: String = "es"): Pokemon
}