package com.fatec.cineapp.core.feature.movie.search.domain.source

import androidx.room.Query
import com.fatec.cineapp.core.data.remote.response.SearchResponse
import com.fatec.cineapp.core.paging.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {
    fun getSearchMoviePagingSource(query: String): MovieSearchPagingSource

    suspend fun getSearchMovies(page:Int,query: String):SearchResponse
}