package com.example.sujinv2px.evolvemvvm.utils

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.Window
import com.example.sujinv2px.evolvemvvm.R
import com.example.sujinv2px.evolvemvvm.databinding.DialogProgressBinding

class ProgressDialogFactory(context: Context, message: String) {

    var binding: DialogProgressBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_progress,
            null,
            false)

    init {
        binding.setMessage(message)

        alertDialog = AlertDialog.Builder(context)
                .setCancelable(false)
                .setView(binding.root)
                .create()
        alertDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

    fun setMessage(message: String) {
        binding.setMessage(message)
    }

    fun showDialog() {
        if (alertDialog != null && !alertDialog!!.isShowing) {
            alertDialog!!.show()
        }
    }

    companion object {

        private var alertDialog: AlertDialog? = null
        private var instance: ProgressDialogFactory? = null

        fun getInstance(context: Context, message: String): ProgressDialogFactory {
            if (instance == null) {
                instance = ProgressDialogFactory(context, message)
            } else {
                instance!!.setMessage(message)
            }
            return instance as ProgressDialogFactory
        }

        fun dismissDialog() {
            if (alertDialog != null && alertDialog!!.isShowing)
                alertDialog!!.dismiss()

            alertDialog = null
            instance = null
        }
    }

}