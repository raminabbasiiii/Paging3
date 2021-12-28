package com.raminabbasiiii.paging3.datasource.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raminabbasiiii.paging3.datasource.db.entity.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Query("SELECT * FROM tbl_movie")
    fun getAllMovie() : PagingSource<Int, Movie>

    @Query("DELETE FROM tbl_movie")
    suspend fun clearAll()

    @Query("SELECT COUNT(id) from tbl_movie")
    suspend fun count(): Int
}