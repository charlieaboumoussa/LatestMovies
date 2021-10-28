package com.example.latestmovies.common.base.models

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg ts: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ts: List<T>)

    @Delete
    suspend fun delete(t: T)

    @Delete
    suspend fun delete(vararg ts: T)

    @Delete
    suspend fun delete(ts: List<T>)

    @Update
    suspend fun update(t: T)

}