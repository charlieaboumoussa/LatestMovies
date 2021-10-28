package com.example.latestmovies

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.latestmovies.model.ServiceLocator

class App : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        ServiceLocator.initializeDatabase(this)
        ServiceLocator.initializeRetrofit(this)
    }
}