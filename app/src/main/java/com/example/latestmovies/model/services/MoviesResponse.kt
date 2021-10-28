package com.example.latestmovies.model.services

import androidx.annotation.Nullable
import com.example.latestmovies.model.database.dao.movie.Movie
import com.google.gson.annotations.SerializedName

class MoviesResponse {

    @Nullable
    @SerializedName("status_message")
    var statusMessage : String? = ""

    @SerializedName("results")
    var results : List<Movie> = emptyList()

}