package com.jessmelo.apps.pokedex.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jessmelo.apps.pokedex.R
import com.jessmelo.apps.pokedex.ui.components.TopBar
import com.jessmelo.apps.pokedex.ui.util.generateRandomPokemonId


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onSearchPokemonName: (pokemonName: String) -> Unit,
    onRandomPokemonClick: (pokemonId: String?) -> Unit
) {
    var searchInput: TextFieldValue by remember {
        mutableStateOf(TextFieldValue("", TextRange(0,50)))
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.pokemon_header1),
                    contentDescription = stringResource(R.string.header_image),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                )
            }
            Row {
                TextField(
                    value = searchInput,
                    shape = RoundedCornerShape(15.dp),
                    onValueChange = { searchInput = it },
                    singleLine = true,
                    label = { Text(stringResource(R.string.search_field)) },
                    placeholder = { Text(stringResource(R.string.search_input_placeholder)) },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .onKeyEvent { keyEvent ->
                            if (keyEvent.key != Key.Enter) return@onKeyEvent false
                            if (keyEvent.type == KeyEventType.KeyUp) {
                                onSearchPokemonName(
                                    searchInput.text
                                        .trim()
                                        .lowercase()
                                )
                            }
                            true
                        },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = stringResource(R.string.search_button)
                        )
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onSearchPokemonName(searchInput.text.trim().lowercase())
                        }
                    )
                )
            }
            FilledTonalButton(
                onClick = { onRandomPokemonClick(generateRandomPokemonId()) },
                content = { Text(
                    text = stringResource(R.string.random_pokemon_button).uppercase(),
                    style = MaterialTheme.typography.labelMedium
                    ) }
            )
        }
    }
}
