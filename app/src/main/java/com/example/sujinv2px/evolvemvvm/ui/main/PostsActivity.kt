package com.example.sujinv2px.evolvemvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.sujinv2px.evolvemvvm.R
import com.example.sujinv2px.evolvemvvm.ui.base.BaseActivity
import com.example.sujinv2px.evolvemvvm.utils.ProgressDialogFactory
import com.example.sujinv2px.evolvemvvm.utils.Response
import com.example.sujinv2px.evolvemvvm.utils.Status
import javax.inject.Inject

class PostsActivity : BaseActivity() {

    @Inject
    lateinit var postViewModelFactory: PostViewModelFactory

    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel = ViewModelProviders.of(this, postViewModelFactory).get(PostViewModel::class.java)
        postViewModel.response().observe(this, Observer {
            processResponse(it)
            if (it?.status == Status.COMPLETE && it.data == "fetch_remote_complete") {
                postViewModel.fetchPostLocal().observe(this, Observer {
                    println("Set adapter")
                })
            }
        })
        postViewModel.fetchPostRemote()
    }

    private fun processResponse(response: Response?) {
        when (response?.status) {
            Status.LOADING -> showProgressDialog("Please wait...")

            Status.COMPLETE -> hideProgressDialog()

            Status.ERROR -> hideProgressDialog()
        }
    }

    private fun showProgressDialog(message: String) {
        ProgressDialogFactory.getInstance(this, message).showDialog()
    }

    private fun hideProgressDialog() {
        ProgressDialogFactory.dismissDialog()
    }
}
