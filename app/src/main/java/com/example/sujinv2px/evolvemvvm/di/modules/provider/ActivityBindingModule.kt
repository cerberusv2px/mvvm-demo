package com.example.sujinv2px.evolvemvvm.di.modules.provider

import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import com.example.sujinv2px.evolvemvvm.ui.main.PostsActivity
import com.example.sujinv2px.evolvemvvm.ui.main.PostActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [
        (PostActivityModule::class)
    ])
    abstract fun bindMainActivity(): PostsActivity
}