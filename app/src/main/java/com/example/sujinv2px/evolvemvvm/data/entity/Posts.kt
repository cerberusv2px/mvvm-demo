package com.example.sujinv2px.evolvemvvm.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName
import retrofit2.http.POST
import android.support.v7.util.DiffUtil


@Entity(tableName = "posts")
data class Posts(
        @PrimaryKey
        @ColumnInfo(name = "id")
        @SerializedName("id")
        var id: Int,
        @ColumnInfo(name = "title")
        @SerializedName("title")
        var title: String,
        @ColumnInfo(name = "body")
        @SerializedName("body")
        var body: String,
        @ColumnInfo(name = "user_id")
        @SerializedName("userId")
        var userId: Int
) {

        companion object {
                var DIFF_CALLBACK = object : DiffUtil.ItemCallback<Posts>() {
                        override fun areItemsTheSame(@NonNull oldItem: Posts, @NonNull newItem: Posts): Boolean {
                                return oldItem.id === newItem.id
                        }

                        override fun areContentsTheSame(@NonNull oldItem: Posts, @NonNull newItem: Posts): Boolean {
                                return oldItem == newItem
                        }
                }
        }

}