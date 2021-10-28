package com.example.latestmovies.model.services

import com.example.latestmovies.model.database.dao.movie.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesServiceInterface {

    @GET("/get")
    suspend fun getMovies(): Call<List<Movie>>
}