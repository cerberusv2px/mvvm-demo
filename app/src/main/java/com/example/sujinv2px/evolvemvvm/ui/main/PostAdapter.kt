package com.example.sujinv2px.evolvemvvm.ui.main

import android.databinding.ViewDataBinding
import com.example.sujinv2px.evolvemvvm.R
import com.example.sujinv2px.evolvemvvm.data.entity.Posts
import com.example.sujinv2px.evolvemvvm.ui.base.BaseAdapter
import com.example.sujinv2px.evolvemvvm.ui.base.BaseViewHolder


class PostAdapter(private val listener: (Posts, Int) -> Unit)
    : BaseAdapter<Posts, PostAdapter.PostViewHolder>(Posts.DIFF_CALLBACK) {

    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): PostViewHolder {
        return PostViewHolder(binding)
    }

    override fun onBindCustomViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item as kotlin.Any)
        holder.itemView.setOnClickListener {
            listener(item, position)
        }
    }

    override fun getLayoutResource() = R.layout.item_post

    inner class PostViewHolder(private val viewBinding: ViewDataBinding) : BaseViewHolder(viewBinding)
}