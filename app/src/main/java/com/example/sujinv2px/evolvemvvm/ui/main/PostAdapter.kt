package com.example.sujinv2px.evolvemvvm.ui.main

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sujinv2px.evolvemvvm.BR
import com.example.sujinv2px.evolvemvvm.R
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.ui.base.BaseViewHolder

class PostAdapter(private val listener: (Posts, Int) -> Unit)
    : PagedListAdapter<Posts, PostAdapter.PostViewHolder>(Posts.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater,
                R.layout.item_post,
                parent,
                false
        )
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item as kotlin.Any)
        holder.itemView.setOnClickListener {
            listener(item, position)
        }
    }

    inner class PostViewHolder(private val viewBinding: ViewDataBinding): BaseViewHolder(viewBinding)
}