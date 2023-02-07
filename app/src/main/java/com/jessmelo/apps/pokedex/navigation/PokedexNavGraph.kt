package com.jessmelo.apps.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jessmelo.apps.pokedex.ui.home.HomeScreen
import com.jessmelo.apps.pokedex.ui.home.HomeViewModel
import com.jessmelo.apps.pokedex.ui.pokemonInfo.PokemonInfoScreen
import com.jessmelo.apps.pokedex.ui.pokemonInfo.PokemonInfoViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun PokedexNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = PokedexDestinations.HOME_ROUTE,
    navActions: PokedexNavigationActions = remember(navController) {
        PokedexNavigationActions(navController)
    }
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(PokedexDestinations.HOME_ROUTE) {
            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModel.provideFactory()
            )
            HomeScreen(
                viewModel = homeViewModel,
                onSearchPokemonName = { navActions.navigateToPokemonPage(it) },
                onRandomPokemonClick = { navActions.navigateToPokemonPage(it) },
            )
        }
        composable(
            "pokemon/{pokemonID}",
            arguments = listOf(
                navArgument(PokedexArgs.POKEMON_ID) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val pokemonID = backStackEntry.arguments?.getString(PokedexArgs.POKEMON_ID)
            val pokemonInfoViewModel: PokemonInfoViewModel = viewModel(
                factory = PokemonInfoViewModel.provideFactory(pokemonID)
            )
            PokemonInfoScreen(pokemonInfoViewModel)
        }
    }
}
