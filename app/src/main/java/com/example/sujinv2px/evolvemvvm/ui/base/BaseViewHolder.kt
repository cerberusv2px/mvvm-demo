package com.example.sujinv2px.evolvemvvm.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.example.sujinv2px.evolvemvvm.BR

open class BaseViewHolder(open val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: kotlin.Any) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}