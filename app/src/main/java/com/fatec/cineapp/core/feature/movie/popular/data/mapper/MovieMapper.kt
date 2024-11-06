package com.fatec.cineapp.core.feature.movie.popular.data.mapper

import com.fatec.cineapp.core.data.remote.model.MovieResult
import com.fatec.cineapp.core.domain.model.Movie
import com.fatec.cineapp.core.util.toBackdropUrl


fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath.toBackdropUrl() ?: ""
    )
}