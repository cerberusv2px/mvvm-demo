package com.example.sujinv2px.evolvemvvm.di.modules.provider

import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import com.example.sujinv2px.evolvemvvm.ui.main.PostActivityModule
import com.example.sujinv2px.evolvemvvm.ui.main.PostsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(PostActivityModule::class)])
    abstract fun bindPostActivity(): PostsActivity
}