package com.example.latestmovies.landing.movies.adapters

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.example.latestmovies.R
import com.example.latestmovies.common.base.BaseViewHolder
import com.example.latestmovies.model.database.dao.movie.Movie
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class MovieViewHolder(@LayoutRes val layoutRes : Int, parent: ViewGroup) : BaseViewHolder<Movie>(layoutRes, parent) {

    override fun onBind(item: Movie, position: Int) {
        val posterUrl = String.format("%s%s", itemView.context.getString(R.string.poster_url), item.posterPath)
        Glide
            .with(itemView.context)
            .load(posterUrl)
            .centerCrop()
            .into(itemView.imageView_poster)
        itemView.textView_title.text = item.title
        itemView.textView_subtitle.text = item.overview
    }
}