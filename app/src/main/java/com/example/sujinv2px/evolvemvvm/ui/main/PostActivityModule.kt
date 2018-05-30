package com.example.sujinv2px.evolvemvvm.ui.main

import com.example.sujinv2px.evolvemvvm.data.local.impl.PostLocalRepository
import com.example.sujinv2px.evolvemvvm.data.remote.impl.PostRemoteRepository
import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import com.example.sujinv2px.evolvemvvm.utils.SchedulersFactory
import dagger.Module
import dagger.Provides

@Module
class PostActivityModule {

    @PerActivity
    @Provides
    internal fun providePostViewModelFactory(
            postLocalRepository: PostLocalRepository,
            postRemoteRepository: PostRemoteRepository,
            schedulersFactory: SchedulersFactory
    ): PostViewModelFactory {

        return PostViewModelFactory(
                postLocalRepository,
                postRemoteRepository,
                schedulersFactory
        )
    }
}