package com.example.sujinv2px.evolvemvvm.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sujinv2px.evolvemvvm.di.scope.PerActivity
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@PerActivity
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator: Provider<ViewModel>? = viewModels[modelClass]
        if (creator == null) {
            for ((key, value) in viewModels) {
                creator = value
                break
            }
        }
        if (creator == null) throw IllegalArgumentException("Unknown model class:$modelClass")
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
