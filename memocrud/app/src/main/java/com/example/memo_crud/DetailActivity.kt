package com.example.memo_crud

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

import com.example.memo_crud.data.AppDatabase
import com.example.memo_crud.data.Memo

class DetailActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    private lateinit var editTitle: EditText
    private lateinit var editContent: EditText

    private lateinit var buttonUpdate: Button
    private lateinit var buttonDelete: Button

    private lateinit var memo: Memo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "memo_database"
        ).allowMainThreadQueries().build()

        editTitle = findViewById(R.id.editTitle)
        editContent = findViewById(R.id.editContent)

        buttonUpdate = findViewById(R.id.buttonUpdate)
        buttonDelete = findViewById(R.id.buttonDelete)

        val memoId = intent.getIntExtra("memoId", -1)

        memo = db.memoDao().getMemoById(memoId)

        editTitle.setText(memo.title)
        editContent.setText(memo.content)

        buttonUpdate.setOnClickListener {

            val updatedMemo = Memo(
                id = memo.id,
                title = editTitle.text.toString(),
                content = editContent.text.toString()
            )

            db.memoDao().updateMemo(updatedMemo)

            Toast.makeText(
                this,
                "更新しました",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }

        buttonDelete.setOnClickListener {

            db.memoDao().deleteMemo(memo)

            Toast.makeText(
                this,
                "削除しました",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}