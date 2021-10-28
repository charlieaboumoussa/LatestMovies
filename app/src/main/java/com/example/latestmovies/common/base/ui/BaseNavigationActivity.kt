package com.example.latestmovies.common.base.ui

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.latestmovies.R
import com.example.latestmovies.common.base.state.BaseViewModel
import kotlinx.android.synthetic.main.activity_base_navigation.*

abstract class BaseNavigationActivity : BaseActivity() {

    private lateinit var mNavGraph: NavGraph
    private lateinit var mNavController: NavController
    private lateinit var mNavHostFragment: NavHostFragment
    private var mCurrentDestination: Int = 0

    private val mNavigationListener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        mCurrentDestination = destination.id
        titleHandling(arguments)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mNavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = mNavHostFragment.navController
        mNavGraph = mNavController.navInflater.inflate(getNavGraph())
        if (getStartDestinationBundle() != null) {
            getNavController().setGraph(mNavGraph, getStartDestinationBundle()!!)
        } else {
            getNavController().graph = mNavGraph
        }
    }

    override fun onResume() {
        super.onResume()
        mNavController.addOnDestinationChangedListener(mNavigationListener)
    }

    override fun onPause() {
        mNavController.removeOnDestinationChangedListener(mNavigationListener)
        super.onPause()
    }

    open fun titleHandling(arguments: Bundle?) {
        var title = ""
        if (arguments != null && arguments.containsKey("title")) {
            arguments.getInt("title").let { strRes ->
                title = getString(strRes)
            }
        }
        if(title.isNotEmpty()) {
            materialToolbar.title = title
        }
    }

    @NavigationRes
    abstract fun getNavGraph(): Int

    open fun getStartDestinationBundle(): Bundle? {
        return null
    }

    open fun getStartDestination(): Int? {
        return null
    }

    fun getNavController(): NavController{
        return mNavController
    }

    override fun getContentViewId(): Int = R.layout.activity_base_navigation

}