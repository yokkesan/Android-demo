package com.example.memo_crud.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memos")
data class Memo(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val content: String
)