package com.example.favorites

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = findViewById<ImageView>(R.id.imageDetail)
        val name = findViewById<TextView>(R.id.textDetailName)
        val shareButton = findViewById<Button>(R.id.buttonShare)

        val artistName = intent.getStringExtra("name")
        val imageResId = intent.getIntExtra("image", 0)

        name.text = artistName
        image.setImageResource(imageResId)

        shareButton.setOnClickListener {

            val text = "おすすめアーティスト: $artistName"

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, text)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "共有")

            startActivity(shareIntent)
        }
    }
}