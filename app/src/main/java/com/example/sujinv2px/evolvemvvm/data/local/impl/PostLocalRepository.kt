package com.example.sujinv2px.evolvemvvm.data.local.impl

import android.arch.lifecycle.LiveData
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.data.local.DatabaseManager
import com.example.sujinv2px.evolvemvvm.domain.repository.PostRepository
import io.reactivex.Observable
import javax.inject.Inject

class PostLocalRepository @Inject constructor(
        private val databaseManager: DatabaseManager
) : PostRepository {
    override fun fetchAPIPost(): Observable<List<Posts>> {
        throw UnsupportedOperationException()
    }

    override fun fetchLocalPost(): LiveData<List<Posts>> {
        return databaseManager.getPostDao().getAll()
    }

    override fun saveLocalPost(posts: List<Posts>) {
        println("Save post")
        return databaseManager.getPostDao().insert(posts)

    }
}