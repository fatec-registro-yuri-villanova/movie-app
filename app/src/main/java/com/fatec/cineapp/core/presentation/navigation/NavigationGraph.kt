package com.fatec.cineapp.core.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fatec.cineapp.core.feature.movie.popular.presentation.MoviePopularScreen
import com.fatec.cineapp.core.feature.movie.popular.presentation.MoviePopularViewModel


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {
            val viewModel: MoviePopularViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            MoviePopularScreen(
                uiState = uiState,
                navigateToDetailMovie = {

                }
            )

        }
        composable(BottomNavItem.MoviewSearch.route) {
            Text(text = "Pesquisar")
        }
        composable(BottomNavItem.MovieFavorite.route) {
            Text(text = "Favoritos")
        }
    }
}