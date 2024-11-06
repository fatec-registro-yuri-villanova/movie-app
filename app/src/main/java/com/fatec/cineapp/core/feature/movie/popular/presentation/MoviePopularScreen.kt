package com.fatec.cineapp.core.feature.movie.popular.presentation

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import com.fatec.cineapp.R
import com.fatec.cineapp.core.feature.movie.popular.presentation.components.MovieContent
import com.fatec.cineapp.core.feature.movie.popular.presentation.state.MoviePopularState
import com.fatec.cineapp.core.util.UtilFunctions
import com.fatec.cineapp.ui.theme.black
import com.fatec.cineapp.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToDetailMovie: (Int) -> Unit
) {
    val movies = uiState.movies.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = white
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(black)
            )
        },
        content = { paddingValues ->
            MovieContent(
               pagingMovies = movies,
                paddingValues =paddingValues,
                onClick = {movieId: Int ->
                    UtilFunctions.logInfo("MOVIE_ID",movieId.toString())
                    navigateToDetailMovie(movieId)
                }
            )
        }
    )
}