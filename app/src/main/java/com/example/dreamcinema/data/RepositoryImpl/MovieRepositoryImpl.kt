package com.example.dreamcinema.data.RepositoryImpl

import com.example.dreamcinema.data.network.api.ApiService
import com.example.dreamcinema.domain.MovieInfo
import com.example.dreamcinema.domain.MovieList
import com.example.dreamcinema.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getTopMovieInfoList(): List<MovieInfo> {
        return apiService.getTopMoviesInfo().movieList.map { it ->
            MovieInfo(
                id = it.id,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage
            )
        }
    }

    override suspend fun getPopularMovieInfoList(): List<MovieInfo> {
        return apiService.getPopularMoviesInfo().movieList.map { it ->
            MovieInfo(
                id = it.id,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage
            )
        }
    }

    override suspend fun getNowPlayingMovieInfoList(): List<MovieInfo> {
        return apiService.getNowPlayingMovieInfo().movieList.map { it ->
            MovieInfo(
                id = it.id,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage
            )
        }
    }

    override suspend fun getUpcomingMovieInfoList(): List<MovieInfo> {
        return apiService.getUpcomingMovieInfo().movieList.map { it ->
            MovieInfo(
                id = it.id,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage
            )
        }
    }


    override suspend fun getAllMovieListsInfo(): List<MovieList> {
        val getTop = MovieList("Top rated movies", getTopMovieInfoList())
        val getUpcoming = MovieList("Upcoming movies", getUpcomingMovieInfoList())
        val getPopular = MovieList("Popular movies", getPopularMovieInfoList())
        val getNowPlaying = MovieList("Now playing movies", getNowPlayingMovieInfoList())
        return listOf(getNowPlaying, getPopular, getTop, getUpcoming)
    }

    override fun getMovieDetailInfo(title: String): MovieInfo {
        TODO("Not yet implemented")
    }
}