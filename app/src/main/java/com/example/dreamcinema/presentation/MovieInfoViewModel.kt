package com.example.dreamcinema.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dreamcinema.domain.useCases.GetMovieDetailInfoUseCase
import com.example.dreamcinema.domain.GetTopMovieInfoListUseCase
import com.example.dreamcinema.domain.MovieInfo
import com.example.dreamcinema.domain.MovieList
import com.example.dreamcinema.domain.useCases.GetAllMovieInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieInfoViewModel @Inject constructor(
    private val getAllMovieInfoUseCase: GetAllMovieInfoUseCase,
    private val getMovieDetailInfoUseCase: GetMovieDetailInfoUseCase
) : ViewModel() {

    private val _listMovie = MutableLiveData<List<MovieList>>()
    val listMovie: LiveData<List<MovieList>> = _listMovie

    fun getAllMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            val lists = getAllMovieInfoUseCase()
            withContext((Dispatchers.Main)) {
                _listMovie.value = lists
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}