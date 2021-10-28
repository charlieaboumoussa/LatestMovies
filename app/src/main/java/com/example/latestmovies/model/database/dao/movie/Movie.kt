package com.example.latestmovies.model.database.dao.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MOVIE")
class Movie {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @ColumnInfo(name = "THUMBNAIL_IMAGE")
    var thumbnailImage = ""

    @ColumnInfo(name = "NAME")
    var movieName = ""
}