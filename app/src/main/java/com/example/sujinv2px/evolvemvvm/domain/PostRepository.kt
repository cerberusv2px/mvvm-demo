package com.example.sujinv2px.evolvemvvm.domain

import android.arch.lifecycle.LiveData
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * This class is used as base for Remote and Local.
 * Both Remote and Local repository implements this class
 */
interface PostRepository {

    fun fetchAPIPost(): Observable<List<Posts>>

    fun fetchLocalPost(): LiveData<List<Posts>>

    fun saveLocalPost(posts: List<Posts>)
}