package com.jessmelo.apps.pokedex.ui.pokemonInfo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.jessmelo.apps.pokedex.data.model.pokemonTypes
import com.jessmelo.apps.pokedex.ui.components.TopBar
import com.jessmelo.apps.pokedex.ui.theme.Pink80
import com.jessmelo.apps.pokedex.ui.theme.PokeLightYellow
import com.jessmelo.apps.pokedex.ui.theme.Righteous
import com.jessmelo.apps.pokedex.ui.util.capitalizeWords
import com.jessmelo.apps.pokedex.ui.util.dcTocm
import com.jessmelo.apps.pokedex.ui.util.hgToKg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonInfoScreen(
    viewModel: PokemonInfoViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(PokeLightYellow),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                uiState.image?.let {imageUrl->
                    val request = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build()

                    SubcomposeAsyncImage(
                        model = request,
                        contentDescription = "Imagem do Pokemon"
                    ) {
                        val state = painter.state
                        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                            CircularProgressIndicator()
                        } else {
                            SubcomposeAsyncImageContent()
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                uiState.name?.let { pokemonName ->
                    Text(
                        text = pokemonName.capitalizeWords(),
                        style = MaterialTheme.typography.headlineLarge,
                        fontFamily = Righteous
                    )
                }
                uiState.errorMessage?.let {msg ->
                    Text(
                        text = msg,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth()
            ) {
                uiState.weight?.let { weight ->
                    Text(
                        text = "Peso: ${hgToKg(weight)}kg",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 15.dp)
                    .fillMaxWidth()
            ) {
                uiState.height?.let { height ->
                    Text(
                        text = "Altura: ${dcTocm(height)}cm",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 15.dp)
                    .fillMaxWidth()
            ) {
                uiState.types?.let { types ->
                    Text(
                        text = "Tipo: ",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal
                    )
                    LazyColumn {
                        items(uiState.types!!) { item ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Canvas(modifier = Modifier
                                    .padding(start = 5.dp, end = 5.dp)
                                    .size(6.dp)){
                                    drawCircle(Color.Black)
                                }
                                Text(
                                    text = pokemonTypes.getValue(item),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
//                    types.forEach {
//                        Text(
//                            text = translateTypeToPT(it),
//                            style = MaterialTheme.typography.bodyMedium,
//                            fontWeight = FontWeight.Normal
//                        )
//                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DefaultPreview() {
    Scaffold(topBar = { TopBar() }) {
        Column(
            modifier = Modifier
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .background(Pink80)
                    .fillMaxWidth()
            ){
                AsyncImage(
                    model = "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/001.png",
                    contentDescription = null,
                    alignment = Alignment.Center
                )
                Text(
                    text = "pikachu".capitalizeWords(),
                    style = MaterialTheme.typography.headlineLarge,
                    fontFamily = Righteous
                )
            }
        }
    }
}
