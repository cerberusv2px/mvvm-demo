package com.example.sujinv2px.evolvemvvm

import android.app.Activity
import android.app.Application
import com.example.sujinv2px.evolvemvvm.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class EvolveApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initializeApplicationComponent()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    private fun initializeApplicationComponent() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }
}