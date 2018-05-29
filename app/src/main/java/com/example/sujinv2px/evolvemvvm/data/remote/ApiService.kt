package com.example.sujinv2px.evolvemvvm.data.remote

import android.arch.lifecycle.LiveData
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun fetchPost(): LiveData<List<Posts>>
}