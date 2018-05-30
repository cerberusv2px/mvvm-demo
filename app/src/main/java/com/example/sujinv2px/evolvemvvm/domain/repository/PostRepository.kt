package com.example.sujinv2px.evolvemvvm.domain.repository

import android.arch.lifecycle.LiveData
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import io.reactivex.Completable
import io.reactivex.Observable

interface PostRepository {

    fun fetchAPIPost(): Observable<List<Posts>>

    fun fetchLocalPost(): LiveData<List<Posts>>

    fun saveLocalPost(posts: List<Posts>)
}