package com.example.sujinv2px.evolvemvvm.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

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
)