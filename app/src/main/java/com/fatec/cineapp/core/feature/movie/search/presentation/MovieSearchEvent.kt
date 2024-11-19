package com.fatec.cineapp.core.feature.movie.search.presentation

sealed class MovieSearchEvent {
    data class EnteredQuery(val value: String) : MovieSearchEvent()
}
