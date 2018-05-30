package com.example.sujinv2px.evolvemvvm.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sujinv2px.evolvemvvm.data.local.impl.PostLocalRepository
import com.example.sujinv2px.evolvemvvm.data.remote.impl.PostRemoteRepository
import com.example.sujinv2px.evolvemvvm.di.qualifier.Local
import com.example.sujinv2px.evolvemvvm.di.qualifier.Remote
import com.example.sujinv2px.evolvemvvm.utils.SchedulersFactory
import javax.inject.Inject

class PostViewModelFactory @Inject constructor(
        @Local private val postLocalRepository: PostLocalRepository,
        @Remote private val postRemoteRepository: PostRemoteRepository,
        private val schedulersFactory: SchedulersFactory
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(
                    postLocalRepository,
                    postRemoteRepository,
                    schedulersFactory) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}