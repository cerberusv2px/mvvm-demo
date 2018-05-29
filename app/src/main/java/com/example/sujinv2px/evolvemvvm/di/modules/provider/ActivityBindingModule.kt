package com.example.sujinv2px.evolvemvvm.di.modules.provider

import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import com.example.sujinv2px.evolvemvvm.ui.main.MainActivity
import com.example.sujinv2px.evolvemvvm.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [
        (MainActivityModule::class)
    ])
    abstract fun bindMainActivity(): MainActivity
}