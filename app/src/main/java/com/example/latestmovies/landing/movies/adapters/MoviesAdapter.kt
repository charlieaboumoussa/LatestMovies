package com.example.latestmovies.landing.movies.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latestmovies.R
import com.example.latestmovies.model.database.dao.movie.Movie

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var mItems : ArrayList<Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(R.layout.view_holder_movie, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = mItems?.get(position)
        movie?.let {
            holder.onBind(movie, position)
        }
    }

    fun setItems(items : ArrayList<Movie>){
        if(mItems == null){
            mItems = arrayListOf()
        }
        mItems?.clear()
        mItems?.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        var count = 0
        mItems?.let {
            count = mItems!!.size
        }
        return count
    }
}