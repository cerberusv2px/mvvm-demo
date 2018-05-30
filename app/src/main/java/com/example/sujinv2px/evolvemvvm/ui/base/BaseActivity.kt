package com.example.sujinv2px.evolvemvvm.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sujinv2px.evolvemvvm.utils.ProgressDialogFactory
import com.example.sujinv2px.evolvemvvm.utils.Response
import com.example.sujinv2px.evolvemvvm.utils.StateManagementFactory
import com.example.sujinv2px.evolvemvvm.utils.Status
import dagger.android.AndroidInjection

open class BaseActivity : AppCompatActivity(), StateManagementFactory {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    private fun showProgressDialog(message: String) {
        ProgressDialogFactory.getInstance(this, message).showDialog()
    }

    private fun hideProgressDialog() {
        ProgressDialogFactory.dismissDialog()
    }

    override fun processResponse(response: Response?) {
        when (response?.status) {
            Status.LOADING -> showProgressDialog("Please wait...")

            Status.COMPLETE -> hideProgressDialog()

            Status.ERROR -> hideProgressDialog()
        }
    }
}