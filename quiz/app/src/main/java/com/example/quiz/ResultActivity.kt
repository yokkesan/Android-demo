package com.example.quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val scoreText = findViewById<TextView>(R.id.textScore)
        val resetButton = findViewById<Button>(R.id.buttonReset)

        val score = intent.getIntExtra("SCORE", 0)
        scoreText.text = "スコア：$score / 10"

        resetButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}