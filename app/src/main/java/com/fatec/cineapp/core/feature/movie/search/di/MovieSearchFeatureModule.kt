package com.fatec.cineapp.core.feature.movie.search.di

import com.fatec.cineapp.core.data.remote.MovieService
import com.fatec.cineapp.core.feature.movie.search.data.repository.MovieSearchRepositoryImpl
import com.fatec.cineapp.core.feature.movie.search.data.source.MovieSearchRemoteDataSourceImpl
import com.fatec.cineapp.core.feature.movie.search.domain.repository.MovieSearchRepository
import com.fatec.cineapp.core.feature.movie.search.domain.source.MovieSearchRemoteDataSource
import com.fatec.cineapp.core.feature.movie.search.domain.usecase.GetMovieSearchUseCase
import com.fatec.cineapp.core.feature.movie.search.domain.usecase.GetMovieSearchUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieSearchFeatureModule {

    @Provides
    @Singleton
    fun provideMovieSearchDataSource(service: MovieService): MovieSearchRemoteDataSource {
        return MovieSearchRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieSearchRepository(remoteDataSource: MovieSearchRemoteDataSource): MovieSearchRepository {
        return MovieSearchRepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }

    @Provides
    @Singleton
    fun provideGetMovieSearchUseCase(
        repository: MovieSearchRepository
    ): GetMovieSearchUseCase {
        return GetMovieSearchUseCaseImpl(
            repository = repository
        )
    }
}