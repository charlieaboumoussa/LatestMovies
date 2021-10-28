package com.example.latestmovies.model.repositories

import androidx.lifecycle.LiveData
import com.example.latestmovies.model.database.dao.movie.Movie
import com.example.latestmovies.model.database.dao.movie.MovieDao
import com.example.latestmovies.model.services.MoviesResponse
import com.example.latestmovies.model.services.MoviesServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository(
    private val moviesService: MoviesServiceInterface,
    private val moviesDao: MovieDao
) {

    private var mGetMoviesInterface : IGetMovies? = null

    interface IGetMovies{
        fun getMoviesSuccess(){}
        fun getMoviesFailed(errorMessage : String){}
    }

    fun getLiveMovies(): LiveData<List<Movie>> {
        return moviesDao.getLiveMovies()
    }

    fun getMovies() {
        moviesService.getLatestMoviesPerWeek().enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                val movies = response.body()?.results
                movies?.let {
                    val scope = CoroutineScope(Dispatchers.IO)
                    scope.launch {
                        moviesDao.insert(movies)
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                t.message?.let {
                    mGetMoviesInterface?.getMoviesFailed(t.message!!)
                }
            }
        })
    }

}