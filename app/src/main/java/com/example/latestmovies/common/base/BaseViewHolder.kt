package com.example.latestmovies.common.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(@LayoutRes layoutRes: Int, parent: ViewGroup)
            : this(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)) {
        onCreate()
    }

    open fun onCreate() {

    }

    abstract fun onBind(item: T, position: Int)

}