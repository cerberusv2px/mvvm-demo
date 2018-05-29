package com.example.sujinv2px.evolvemvvm.ui.main

import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideView(activity: MainActivity): MainActivity {
        return activity
    }
}