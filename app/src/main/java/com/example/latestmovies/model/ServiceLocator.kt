package com.example.latestmovies.model

import android.content.Context
import androidx.room.Room
import com.example.latestmovies.R
import com.example.latestmovies.model.database.AppDatabase
import com.example.latestmovies.model.database.dao.movie.MovieDao
import com.example.latestmovies.model.services.MoviesServiceInterface
import okhttp3.OkHttpClient
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
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val url = chain
                            .request()
                            .url()
                            .newBuilder()
                            .addQueryParameter("api_key", context.getString(R.string.api_key))
                            .build()
                        chain.proceed(chain.request().newBuilder().url(url).build())
                    }
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit() : Retrofit?{
        return mRetrofit
    }

    fun getMoviesDao() : MovieDao?{
        return mDatabase?.moviesDao()
    }

    fun getRetrofitMoviesService() : MoviesServiceInterface?{
        return mRetrofit?.create(MoviesServiceInterface::class.java)
    }
}