package com.example.latestmovies.landing.movies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.latestmovies.R
import com.example.latestmovies.common.base.ui.BaseFragment
import com.example.latestmovies.landing.movies.adapters.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : BaseFragment<MoviesViewModel>() {

    private var mMoviesAdapter : MoviesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.getMovies()
        observeMovies()
    }

    fun setupRecyclerView(){
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        mMoviesAdapter = MoviesAdapter()
        recyclerView.adapter = mMoviesAdapter
    }

    fun observeMovies(){
        viewModel.liveMovies().observe(viewLifecycleOwner, Observer { movies->
            movies?.apply {
                mMoviesAdapter?.setItems(ArrayList(movies))
            }
        })
    }

    override fun getContentViewId(): Int = R.layout.fragment_movies

    override fun getViewModelClass(): Class<MoviesViewModel> = MoviesViewModel::class.java

}