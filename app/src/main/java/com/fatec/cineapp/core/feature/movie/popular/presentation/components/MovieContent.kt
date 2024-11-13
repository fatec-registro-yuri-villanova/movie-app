package com.fatec.cineapp.core.feature.movie.popular.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.fatec.cineapp.core.domain.model.Movie
import com.fatec.cineapp.core.presentation.components.common.ErrorScreen
import com.fatec.cineapp.core.presentation.components.common.ErrorScreenPreview
import com.fatec.cineapp.core.presentation.components.common.LoadingView

@Composable
fun MovieContent(
    modifier: Modifier = Modifier,
    pagingMovies: LazyPagingItems<Movie>,
    paddingValues: PaddingValues,
    onClick: (movieId: Int) -> Unit
) {
    Box(
        modifier = modifier.background(Color.Black)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingMovies.itemCount) { index ->
                val movie = pagingMovies[index]
                movie?.let {
                    MovieItem(
                        voteAverage = it.voteAverage,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        onClick = { movieId ->
                            onClick(movieId)
                        }
                    )
                }
            }
//            GridItemSpan - explicação
//            item(span = { GridItemSpan(maxLineSpan) }): Essa linha define um item na grade (grid)
//            onde a visualização de carregamento será exibida.
//            A função span é usada para especificar o número de colunas que o item ocupa na grade.
//            No caso, GridItemSpan(maxLineSpan) retorna um objeto SpanSize,
//            indicando que o item deve ocupar um número máximo de linhas (maxLineSpan) na grade.
            pagingMovies.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingView()
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingView()
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = "Verifique sua conexão com a internet",
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }

                    loadState.append is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = "Verifique sua conexão com a internet",
                                retry = {
                                    retry()
                                }
                            )
                        }
                    }
                }
            }
        }
    }

}