package com.example.dreamcinema.data.network.api

import com.example.dreamcinema.data.network.api.dto.GenreListDto
import com.example.dreamcinema.data.network.api.dto.MovieCastListDto
import com.example.dreamcinema.data.network.api.dto.MovieInfoDto
import com.example.dreamcinema.data.network.api.dto.MovieInfoListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/top_rated")
    suspend fun getTopMoviesInfo(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/movie/popular")
    suspend fun getPopularMoviesInfo(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/movie/now_playing")
    suspend fun getNowPlayingMovieInfo(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovieInfo(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/movie/latest")
    suspend fun getLatestMovieInfo(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") movieId: Int,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoDto

    @GET("3/movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") movieId: Int,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieCastListDto

    @GET("3/movie/{movie_id}/similar")
    suspend fun getRecommendedMovies(
        @Path("movie_id") movieId: Int,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): MovieInfoListDto

    @GET("3/genre/movie/list")
    suspend fun getGenre(
        @Query(QUERY_PARAM_API_KEY) api_key: String = API_KEY_VALUE,
        @Query(QUERY_PARAM_LANGUAGE) language: String = LANGUAGE
    ): GenreListDto


    companion object {

        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LANGUAGE = "language"
        private const val LANGUAGE = "eng-ENG"
        private const val API_KEY_VALUE = "139c985f543aaf9db3e818b31275a4c1"
    }
}