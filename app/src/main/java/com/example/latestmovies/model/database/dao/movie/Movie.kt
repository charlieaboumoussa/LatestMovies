package com.example.latestmovies.model.database.dao.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "MOVIE")
class Movie {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = 0

    @ColumnInfo(name = "POSTER_PATH")
    @SerializedName("poster_path")
    var posterPath = ""

    @ColumnInfo(name = "TITLE")
    @SerializedName("original_title")
    var title = ""

    @ColumnInfo(name = "OVERVIEW")
    @SerializedName("overview")
    var overview = ""
}