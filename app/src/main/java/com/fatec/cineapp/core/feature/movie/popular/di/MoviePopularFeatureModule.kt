package com.fatec.cineapp.core.feature.movie.popular.di

import com.fatec.cineapp.core.data.remote.MovieService
import com.fatec.cineapp.core.feature.movie.popular.data.repository.MoviePopularRepositoryImpl
import com.fatec.cineapp.core.feature.movie.popular.data.source.MoviePopularRemoteDataSourceImpl
import com.fatec.cineapp.core.feature.movie.popular.domain.repository.MoviePopularRepository
import com.fatec.cineapp.core.feature.movie.popular.domain.source.MoviePopularRemoteDataSource
import com.fatec.cineapp.core.feature.movie.popular.domain.usecase.GetPopularMoviesUseCase
import com.fatec.cineapp.core.feature.movie.popular.domain.usecase.GetPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFeatureModule {

    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesPopularUseCase(movieRepository: MoviePopularRepository): GetPopularMoviesUseCase{
        return GetPopularMoviesUseCaseImpl(repository = movieRepository)
    }

}