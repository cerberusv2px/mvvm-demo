package com.example.sujinv2px.evolvemvvm.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.sujinv2px.evolvemvvm.data.entity.Posts

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<Posts>)

    @Query("SELECT * FROM posts")
    //fun getAll(): LiveData<List<Posts>>
    fun getAll(): DataSource.Factory<Int, Posts>
}