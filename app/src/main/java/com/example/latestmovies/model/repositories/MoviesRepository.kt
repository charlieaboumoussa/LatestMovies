package com.example.latestmovies.model.repositories

import com.example.latestmovies.common.base.models.Resource
import com.example.latestmovies.model.database.dao.movie.Movie
import com.example.latestmovies.model.database.dao.movie.MovieDao
import com.example.latestmovies.model.services.MoviesServiceInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.withContext

class MoviesRepository(val moviesService: MoviesServiceInterface,
                       val moviesDao: MovieDao) {

//    suspend fun getMovies() : Resource<List<Movie>>{
//        return withContext(Dispatchers.IO){
//            val movies = moviesService.getMovies()
//            Resource.Success(movies)
//        }
//    }

}