package com.example.latestmovies.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.latestmovies.model.database.dao.movie.Movie
import com.example.latestmovies.model.database.dao.movie.MovieDao

@Database(entities = [Movie::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDao() : MovieDao

}
