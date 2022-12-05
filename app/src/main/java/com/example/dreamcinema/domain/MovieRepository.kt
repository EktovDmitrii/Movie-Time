package com.example.dreamcinema.domain

import androidx.lifecycle.LiveData

interface MovieRepository {

    suspend fun getTopMovieInfoList(): List<MovieInfo>

    suspend fun getPopularMovieInfoList(): List<MovieInfo>

    suspend fun getNowPlayingMovieInfoList(): List<MovieInfo>

    suspend fun getUpcomingMovieInfoList(): List<MovieInfo>

    suspend fun getAllMovieListsInfo(): List<MovieList>

    suspend fun getDetails(movieId: Int): MovieInfo

    suspend fun getMovieCast(movieId: Int): List<MovieCast>

    suspend fun getRecommendedMoviesList(movieId: Int): List<MovieInfo>

    suspend fun getGenreInfo(): List<Genre>

    suspend fun getMoviesByGenre(genreId: Int): List<MovieInfo>

    suspend fun addMovie(movieInfo: MovieInfo)

    suspend fun getMovie(movieId: Int): MovieInfo

    fun getMovieList(): LiveData<List<MovieInfo>>

    suspend fun deleteMovie(movieInfo: MovieInfo)
}
