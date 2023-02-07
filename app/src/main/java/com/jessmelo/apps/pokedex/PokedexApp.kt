package com.jessmelo.apps.pokedex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jessmelo.apps.pokedex.navigation.PokedexNavGraph
import com.jessmelo.apps.pokedex.ui.theme.PokedexTheme

@Composable
fun PokedexApp() {
    PokedexTheme {
        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PokedexNavGraph(
                navController = navController
            )
        }
    }
}
