package com.example.sujinv2px.evolvemvvm.data.local

import android.content.Context
import com.example.sujinv2px.evolvemvvm.data.local.dao.PostDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseManager @Inject constructor(context: Context) {

    val instance = EvolveDatabase.getInstance(context)

    fun getPostDao(): PostDao {
        return instance.getPostsDao()
    }
}