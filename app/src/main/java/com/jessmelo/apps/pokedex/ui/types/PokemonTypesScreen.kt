package com.jessmelo.apps.pokedex.ui.types

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jessmelo.apps.pokedex.data.model.pokemonTypes
import com.jessmelo.apps.pokedex.ui.components.TopBar
import com.jessmelo.apps.pokedex.ui.theme.PokeLightYellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTypesScreen() {
    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            pokemonTypes.forEach { (key, value) ->
                PokemonTypeRow(value)
            }
        }
    }
}

@Composable
fun PokemonTypeRow(pokemonType: String) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(PokeLightYellow)
            .fillMaxWidth()
    ) {
        Text(
            text = pokemonType.uppercase(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    PokemonTypesScreen()
}
