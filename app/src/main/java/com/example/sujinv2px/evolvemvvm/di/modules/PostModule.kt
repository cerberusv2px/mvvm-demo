package com.example.sujinv2px.evolvemvvm.di.modules

import com.example.sujinv2px.evolvemvvm.data.local.DatabaseManager
import com.example.sujinv2px.evolvemvvm.data.local.impl.PostLocalRepository
import com.example.sujinv2px.evolvemvvm.data.remote.ApiService
import com.example.sujinv2px.evolvemvvm.data.remote.impl.PostRemoteRepository
import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import com.example.sujinv2px.evolvemvvm.domain.PostRepository
import dagger.Module
import dagger.Provides

@Module
open class PostModule {

    @Provides
    @PerActivity
    fun providePostLocalRepository(databaseManager: DatabaseManager): PostRepository {
        return PostLocalRepository(databaseManager)
    }

    @Provides
    @PerActivity
    fun providePostRemoteRepository(apiService: ApiService): PostRepository {
        return PostRemoteRepository(apiService)
    }
}