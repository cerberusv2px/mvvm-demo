package com.example.sujinv2px.evolvemvvm.di.component

import android.app.Application
import com.example.sujinv2px.evolvemvvm.EvolveApplication
import com.example.sujinv2px.evolvemvvm.di.modules.ApplicationModule
import com.example.sujinv2px.evolvemvvm.di.modules.provider.ActivityBindingModule
import com.example.sujinv2px.evolvemvvm.di.modules.provider.ViewModelModule
import com.example.sujinv2px.evolvemvvm.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [
    (ActivityBindingModule::class),
    (ViewModelModule::class),
    (ApplicationModule::class),
    (AndroidSupportInjectionModule::class)
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent

    }

    fun inject(app: EvolveApplication)
}