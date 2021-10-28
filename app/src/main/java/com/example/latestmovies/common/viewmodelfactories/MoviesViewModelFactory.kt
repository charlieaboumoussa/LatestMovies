package com.example.latestmovies.common.viewmodelfactories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.latestmovies.landing.movies.MoviesViewModel
import com.example.latestmovies.model.database.dao.movie.MovieDao
import com.example.latestmovies.model.services.MoviesServiceInterface

class MoviesViewModelFactory(var moviesServiceInterface: MoviesServiceInterface,
                           var movieDao: MovieDao) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (MoviesViewModel(moviesServiceInterface,
            movieDao) as T)
}