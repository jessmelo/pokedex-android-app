package com.jessmelo.apps.pokedex.network

import com.jessmelo.apps.pokedex.network.model.PokemonInfo
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object PokemonServer {
    private const val baseUrl = "https://pokeapi.co/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

interface PokemonAPI {
    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String) : Response<PokemonInfo>
}
