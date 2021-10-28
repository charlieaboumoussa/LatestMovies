package com.example.latestmovies.landing

import android.os.Bundle
import com.example.latestmovies.R
import com.example.latestmovies.common.base.ui.BaseNavigationActivity

class MoviesActivity : BaseNavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getNavGraph(): Int = R.navigation.nav_graph_movies

}