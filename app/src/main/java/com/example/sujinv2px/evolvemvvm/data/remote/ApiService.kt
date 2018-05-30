package com.example.sujinv2px.evolvemvvm.data.remote


import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun fetchPost(): Observable<List<Posts>>
}