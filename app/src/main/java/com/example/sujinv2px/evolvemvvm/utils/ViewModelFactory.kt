package com.example.sujinv2px.evolvemvvm.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@PerActivity
class ViewModelFactory @Inject constructor(private val viewModels:MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModels[modelClass]?.get() as T
    }
}
