package com.example.sujinv2px.evolvemvvm.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.sujinv2px.evolvemvvm.utils.ProgressDialogFactory
import dagger.android.AndroidInjection

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

}