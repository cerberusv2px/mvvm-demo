package com.example.sujinv2px.evolvemvvm.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.data.local.dao.PostDao

@Database(entities = [
    (Posts::class)
], version = 1)
abstract class EvolveDatabase : RoomDatabase() {

    companion object {
        var instance: EvolveDatabase? = null
        fun getInstance(context: Context): EvolveDatabase {
            if (instance == null) {
                instance = createInstance(context)
            }
            return instance as EvolveDatabase
        }

        private fun createInstance(context: Context): EvolveDatabase {
            return Room.databaseBuilder(context, EvolveDatabase::class.java, "evolve.db")
                    .build()
        }
    }

    abstract fun getPostsDao(): PostDao
}