package com.fatec.cineapp.core.feature.movie.popular.presentation.state

import androidx.paging.PagingData
import com.fatec.cineapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MoviePopularState(
    val movies: Flow<PagingData<Movie>> = emptyFlow()
)