package com.jessmelo.apps.pokedex.ui.pokemonInfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jessmelo.apps.pokedex.data.PokemonAPI
import com.jessmelo.apps.pokedex.data.PokemonServer
import com.jessmelo.apps.pokedex.data.model.PokemonInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

data class PokemonInfoState(
    val name: String? = null,
    val image: String? = null,
    val weight: Int? = null,
    val height: Int? = null,
    val types: MutableList<String>? = null,
    val errorMessage: String? = null
)

class PokemonInfoViewModel (
    pokemonName: String?
): ViewModel() {
    private val _uiState = MutableStateFlow(PokemonInfoState())
    val uiState: StateFlow<PokemonInfoState> = _uiState.asStateFlow()
    private val pokemonAPI = PokemonServer.getInstance().create(PokemonAPI::class.java)

    private fun getPokemonData(pokemonName: String?) {
        viewModelScope.launch {
            if (pokemonName != null) {
                val response: Response<PokemonInfo> = pokemonAPI.getPokemon(pokemonName)
                if (response.isSuccessful) {
                    val listTypes = mutableListOf<String>()
                    response.body()?.types?.forEach {
                        it.type?.name?.let { listTypes.add(it) }
                    }
                    _uiState.update {currentState ->
                        currentState.copy(
                            name = response.body()?.name,
                            image = response.body()?.sprites?.other?.officialArtwork?.frontDefault,
                            weight = response.body()?.weight,
                            height = response.body()?.height,
                            types = listTypes
                        )
                    }
                } else {
                    _uiState.update { currentState ->
                        currentState.copy(
                            errorMessage = "Não encontramos esse Pokémon :("
                        )
                    }
                }
            }
        }
    }

    init {
        getPokemonData(pokemonName)
    }

    companion object {
        fun provideFactory(
            pokemonName: String?,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PokemonInfoViewModel(pokemonName) as T
            }
        }
    }
}
