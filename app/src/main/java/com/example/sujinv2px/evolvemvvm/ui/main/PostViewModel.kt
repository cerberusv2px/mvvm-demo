package com.example.sujinv2px.evolvemvvm.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.data.local.impl.PostLocalRepository
import com.example.sujinv2px.evolvemvvm.data.remote.impl.PostRemoteRepository
import com.example.sujinv2px.evolvemvvm.di.qualifier.Local
import com.example.sujinv2px.evolvemvvm.di.qualifier.Remote
import com.example.sujinv2px.evolvemvvm.utils.Response
import com.example.sujinv2px.evolvemvvm.utils.SchedulersFactory
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostViewModel @Inject constructor(
        @Local private val postLocalRepository: PostLocalRepository,
        @Remote private val postRemoteRepository: PostRemoteRepository,
        private val schedulersFactory: SchedulersFactory
) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val response = MutableLiveData<Response>()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    fun response(): MutableLiveData<Response> {
        return response
    }


    fun fetchPostRemote() {
        disposables.add(postRemoteRepository.fetchAPIPost()
                .doOnNext {
                    postLocalRepository.saveLocalPost(it)
                }
                .subscribeOn(schedulersFactory.provideIO())
                .observeOn(schedulersFactory.provideUI())
                .doOnSubscribe {
                    response.value = Response.loading()
                }
                .subscribe({
                    response.value = Response.complete(PostState.FETCH_REMOTE_COMPLETE)

                }, { error ->
                    response.value = Response.error(error)
                    println("Error:${error.message}")
                }, {
                })
        )
    }

    fun fetchPostLocal(): LiveData<List<Posts>> {
        return postLocalRepository.fetchLocalPost()
    }

}

