package com.fatec.cineapp.core.feature.movie.search.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.fatec.cineapp.core.domain.model.MovieSearch
import com.fatec.cineapp.core.feature.movie.search.domain.repository.MovieSearchRepository
import com.fatec.cineapp.core.feature.movie.search.domain.source.MovieSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieSearchRemoteDataSource
) : MovieSearchRepository {
    override fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>> {

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getSearchMoviePagingSource(query = query)
            }
        ).flow
    }
}