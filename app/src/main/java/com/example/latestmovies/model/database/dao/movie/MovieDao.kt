package com.example.latestmovies.model.database.dao.movie

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.latestmovies.common.base.models.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao : BaseDao<Movie> {

    @Query("SELECT * FROM MOVIE")
    suspend fun getMovies() : List<Movie>

    @Query("SELECT * FROM MOVIE")
    fun getLiveMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM MOVIE")
    fun getFlowMovies(): Flow<List<Movie>>

    @Query("DELETE FROM MOVIE")
    suspend fun nuke()

}