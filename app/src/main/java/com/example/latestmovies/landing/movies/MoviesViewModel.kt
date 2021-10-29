package com.example.latestmovies.landing.movies

import androidx.lifecycle.LiveData
import com.example.latestmovies.common.base.state.BaseViewModel
import com.example.latestmovies.model.ServiceLocator
import com.example.latestmovies.model.database.dao.movie.Movie
import com.example.latestmovies.model.database.dao.movie.MovieDao
import com.example.latestmovies.model.repositories.MoviesRepository
import com.example.latestmovies.model.services.MoviesServiceInterface

class MoviesViewModel() : BaseViewModel() {

    private var _moviesRepository : MoviesRepository = MoviesRepository(
        ServiceLocator.getRetrofitMoviesService()!!,
        ServiceLocator.getMoviesDao()!!
    )

    constructor(moviesServiceInterface: MoviesServiceInterface, movieDao: MovieDao) : this(){
        _moviesRepository = MoviesRepository(moviesServiceInterface, movieDao)
    }

    fun getMovies(){
//        viewModelScope.launch {
            _moviesRepository.getMovies()
//        }
    }

    fun liveMovies() : LiveData<List<Movie>>{
        return _moviesRepository.getLiveMovies()
    }

}