package com.example.sujinv2px.evolvemvvm.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersFactory @Inject constructor() {

    fun provideIO(): Scheduler {
        return Schedulers.io()
    }

    fun provideUI(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}