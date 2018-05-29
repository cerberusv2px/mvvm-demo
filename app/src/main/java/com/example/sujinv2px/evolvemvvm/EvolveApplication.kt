package com.example.sujinv2px.evolvemvvm

import android.app.Activity
import android.app.Application
import com.example.sujinv2px.evolvemvvm.di.component.DaggerApplicationComponent
import com.facebook.stetho.Stetho
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
        initializeStetho()
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

    private fun initializeStetho() {
        val builder = Stetho.newInitializerBuilder(this)
        builder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        builder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
        Stetho.initialize(builder.build())
    }
}