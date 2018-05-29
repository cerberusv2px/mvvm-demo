package com.example.sujinv2px.evolvemvvm.di.modules

import android.app.Application
import android.content.Context
import com.example.sujinv2px.evolvemvvm.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }
}