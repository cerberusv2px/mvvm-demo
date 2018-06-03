package com.example.sujinv2px.evolvemvvm.ui.base

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<T, VH : BaseViewHolder>(c: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, VH>(c) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                layoutInflater,
                getLayoutResource(),
                parent,
                false
        )
        return getViewHolder(binding, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindCustomViewHolder(holder, position)
    }

    abstract fun getViewHolder(binding: ViewDataBinding, viewType: Int): VH

    abstract fun onBindCustomViewHolder(holder: VH, position: Int)

    abstract fun getLayoutResource(): Int
}