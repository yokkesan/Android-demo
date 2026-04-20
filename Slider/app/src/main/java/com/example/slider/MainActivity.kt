package com.example.slider

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 表示データ
    private val images = listOf(
        R.drawable.dog,
        R.drawable.horse,
        R.drawable.kitten
    )

    private val texts = listOf(
        "①",
        "②",
        "③"
    )

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 初期表示
        update()

        // 右ボタン
        binding.btnToRight.setOnClickListener {
            index++
            if (index >= images.size) index = 0
            update()
        }

        // 左ボタン
        binding.btnToLeft.setOnClickListener {
            index--
            if (index < 0) index = images.size - 1
            update()
        }
    }

    private fun update() {
        binding.imageView.setImageResource(images[index])
        binding.textView3.text = texts[index]
    }
}