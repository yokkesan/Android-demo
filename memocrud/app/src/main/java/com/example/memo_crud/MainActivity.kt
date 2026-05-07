package com.example.memo_crud

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.content.Intent

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room

import com.example.memo_crud.data.AppDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    private lateinit var buttonAdd: Button
    private lateinit var listViewMemo: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "memo_database"
        ).allowMainThreadQueries().build()

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        buttonAdd = findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {

            val intent = Intent(
                this,
                AddMemoActivity::class.java
            )

            startActivity(intent)
        }

        listViewMemo = findViewById(R.id.listViewMemo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }

    override fun onResume() {
        super.onResume()

        val memoList = db.memoDao().getAllMemos()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            memoList.map { it.title }
        )

        listViewMemo.adapter = adapter

        listViewMemo.setOnItemClickListener { _, _, position, _ ->

            val memo = memoList[position]

            val intent = Intent(
                this,
                DetailActivity::class.java
            )

            intent.putExtra("memoId", memo.id)

            startActivity(intent)
        }
    }
}