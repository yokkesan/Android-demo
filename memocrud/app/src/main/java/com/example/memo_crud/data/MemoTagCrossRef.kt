package com.example.memo_crud.data
import androidx.room.Entity

@Entity(
    tableName = "memo_tag_cross_ref",
    primaryKeys = ["memoId", "tagId"]
)
data class MemoTagCrossRef(

    val memoId: Int,

    val tagId: Int
)