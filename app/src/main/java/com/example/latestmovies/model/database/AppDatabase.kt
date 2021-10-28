package com.example.latestmovies.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.latestmovies.model.database.dao.movie.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {



}
