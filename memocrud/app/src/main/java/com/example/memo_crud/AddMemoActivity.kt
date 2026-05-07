package com.example.memo_crud

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

import com.example.memo_crud.data.AppDatabase
import com.example.memo_crud.data.Memo

class AddMemoActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    private lateinit var editTitle: EditText
    private lateinit var editContent: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_memo)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "memo_database"
        ).allowMainThreadQueries().build()

        editTitle = findViewById(R.id.editTitle)
        editContent = findViewById(R.id.editContent)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {

            val title = editTitle.text.toString()
            val content = editContent.text.toString()

            val memo = Memo(
                title = title,
                content = content
            )

            db.memoDao().insertMemo(memo)

            Toast.makeText(
                this,
                "保存しました",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}