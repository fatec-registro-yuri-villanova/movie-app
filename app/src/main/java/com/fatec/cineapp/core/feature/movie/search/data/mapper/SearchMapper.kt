package com.fatec.cineapp.core.feature.movie.search.data.mapper

import com.fatec.cineapp.core.data.remote.model.SearchResult
import com.fatec.cineapp.core.domain.model.MovieSearch
import com.fatec.cineapp.core.util.toPostUrl

fun List<SearchResult>.toMovieSearch() = map { searchResult ->
    MovieSearch(
        id = searchResult.id,
        imageUrl = searchResult.posterPath.toPostUrl(),
        voteAverage = searchResult.voteAverage
    )
}