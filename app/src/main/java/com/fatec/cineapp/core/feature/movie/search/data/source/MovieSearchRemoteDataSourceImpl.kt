package com.fatec.cineapp.core.feature.movie.search.data.source

import com.fatec.cineapp.core.data.remote.MovieService
import com.fatec.cineapp.core.data.remote.response.SearchResponse
import com.fatec.cineapp.core.feature.movie.search.domain.source.MovieSearchRemoteDataSource
import com.fatec.cineapp.core.paging.MovieSearchPagingSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page = page, query = query)
    }
}