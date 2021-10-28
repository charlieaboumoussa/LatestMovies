package com.example.latestmovies.landing.movies

import com.example.latestmovies.common.base.models.Resource
import com.example.latestmovies.common.base.state.BaseViewModel
import com.example.latestmovies.common.base.state.SingleLiveEvent
import com.example.latestmovies.model.database.dao.movie.Movie
import com.example.latestmovies.model.repositories.MoviesRepository

class MoviesViewModel : BaseViewModel() {

    private val _moviesRepository : MoviesRepository = MoviesRepository()
    private var _liveMovies : SingleLiveEvent<Resource<List<Movie>>> = SingleLiveEvent()

    fun liveMovies() : SingleLiveEvent<Resource<List<Movie>>>{
        return _liveMovies
    }

}