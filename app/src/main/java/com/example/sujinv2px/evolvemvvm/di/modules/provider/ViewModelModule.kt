package com.example.sujinv2px.evolvemvvm.di.modules.provider

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sujinv2px.evolvemvvm.di.scope.PerViewModel
import com.example.sujinv2px.evolvemvvm.ui.main.PostViewModel
import com.example.sujinv2px.evolvemvvm.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @PerViewModel(PostViewModel::class)
    internal abstract fun postListViewModel(viewModel: PostViewModel): ViewModel
}