package com.example.sujinv2px.evolvemvvm.ui.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface PostActivitySubComponent : AndroidInjector<PostsActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<PostsActivity>()
}