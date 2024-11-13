package com.fatec.cineapp.core.feature.movie.search.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fatec.cineapp.core.domain.model.MovieSearch
import kotlinx.coroutines.flow.Flow

interface MovieSearchRepository {
    fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>>
}