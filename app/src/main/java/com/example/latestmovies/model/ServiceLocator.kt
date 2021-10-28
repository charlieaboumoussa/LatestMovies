package com.example.latestmovies.model

import android.content.Context
import androidx.room.Room
import com.example.latestmovies.R
import com.example.latestmovies.model.database.AppDatabase
import com.example.latestmovies.model.services.MoviesServiceInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceLocator {

    private const val DATABASE_NAME = "DATABASE"
    private var mDatabase : AppDatabase? = null
    private var mRetrofit : Retrofit? = null

    fun initializeDatabase(context: Context) {
        if(mDatabase == null) {
            mDatabase = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
//                .addMigrations()
                .build()
        }
    }

    fun initializeRetrofit(context: Context){
        mRetrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.api))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}