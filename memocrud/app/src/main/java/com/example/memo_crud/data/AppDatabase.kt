package com.example.memo_crud.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Memo::class,
        Tag::class,
        MemoTagCrossRef::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDao
}