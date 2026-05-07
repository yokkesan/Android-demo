package com.example.memo_crud.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MemoDao {

    @Query("SELECT * FROM memos")
    fun getAllMemos(): List<Memo>

    @Query("SELECT * FROM memos WHERE id = :id")
    fun getMemoById(id: Int): Memo

    @Insert
    fun insertMemo(memo: Memo)

    @Update
    fun updateMemo(memo: Memo)

    @Delete
    fun deleteMemo(memo: Memo)
}