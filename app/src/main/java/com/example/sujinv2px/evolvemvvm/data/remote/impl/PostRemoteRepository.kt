package com.example.sujinv2px.evolvemvvm.data.remote.impl

import android.arch.lifecycle.LiveData
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.data.remote.ApiService
import com.example.sujinv2px.evolvemvvm.domain.PostRepository
import io.reactivex.Observable
import javax.inject.Inject

class PostRemoteRepository @Inject constructor(
        private val apiService: ApiService
) : PostRepository {
    override fun fetchAPIPost(): Observable<List<Posts>> {
        return apiService.fetchPost()
    }

    override fun fetchLocalPost(): LiveData<List<Posts>> {
        throw UnsupportedOperationException()
    }

    override fun saveLocalPost(posts: List<Posts>) {
        throw UnsupportedOperationException()
    }
}