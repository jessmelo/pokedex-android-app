package com.jessmelo.apps.pokedex.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.jessmelo.apps.pokedex.navigation.PokedexArgs.POKEMON_ID
import com.jessmelo.apps.pokedex.navigation.PokedexScreens.HOME_SCREEN
import com.jessmelo.apps.pokedex.navigation.PokedexScreens.POKEMON_SCREEN

object PokedexScreens {
    const val HOME_SCREEN = "home"
    const val POKEMON_SCREEN = "pokemon"
}

object PokedexArgs {
    const val POKEMON_ID = "pokemonID"
}

object PokedexDestinations {
    const val HOME_ROUTE = HOME_SCREEN
    const val POKEMON_ROUTE = "$POKEMON_SCREEN/${POKEMON_ID}"
}

class PokedexNavigationActions(private val navController: NavHostController) {
    fun navigateToHome() {
        navController.navigate(PokedexDestinations.HOME_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }

    fun navigateToPokemonPage(pokemonID: String?) {
        navController.navigate("$POKEMON_SCREEN/$pokemonID")
    }
}
