package com.example.flower_demoxml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.flowerImage)
        val button = findViewById<Button>(R.id.waterButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val text = findViewById<TextView>(R.id.statusText)

        val controller = FlowerController(image, text)

        button.setOnClickListener {
            controller.onWater()
        }

        resetButton.setOnClickListener {
            controller.onReset()
        }
    }

}