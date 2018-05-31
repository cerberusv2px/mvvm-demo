package com.example.sujinv2px.evolvemvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.sujinv2px.evolvemvvm.R
import com.example.sujinv2px.evolvemvvm.ui.base.BaseActivity
import com.example.sujinv2px.evolvemvvm.utils.Status
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostsActivity : BaseActivity() {

    @Inject
    lateinit var postViewModelFactory: PostViewModelFactory

    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel = ViewModelProviders.of(this, postViewModelFactory).get(PostViewModel::class.java)
        postViewModel.let {
            lifecycle.addObserver(it)
        }
        post_recyclerview.layoutManager = LinearLayoutManager(this)
        val adapter = PostAdapter { posts, position ->
            println("Posts:$posts")
        }
        postViewModel.response().observe(this, Observer {
            super.processResponse(it)

            if (it?.status == Status.COMPLETE) {
                when (it.data) {
                    PostState.FETCH_REMOTE_COMPLETE ->
                        postViewModel.fetchPostLocal().observe(this, Observer {
                            adapter.submitList(it)
                            post_recyclerview.adapter = adapter
                        })
                }
            }
        })
        postViewModel.fetchPostRemote()

    }

}
