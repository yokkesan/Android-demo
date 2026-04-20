package com.example.flower_demoxml

import android.widget.ImageView
import android.widget.TextView
import com.example.flower_demoxml.R

class FlowerController(
    private val image: ImageView,
    private val text: TextView
) {
    private var stage = 0

    fun onWater() {
        stage++

        when (stage) {
            1 -> {
                image.setImageResource(R.drawable.f1)
                text.text = "水をあげました"
            }
            2 -> {
                image.setImageResource(R.drawable.f2)
                text.text = "少し育ってきました"
            }
            3 -> {
                image.setImageResource(R.drawable.f3)
                text.text = "つぼみが出てきました"
            }
            4 -> {
                image.setImageResource(R.drawable.f4)
                text.text = "もうすぐ咲きます"
            }
            5 -> {
                image.setImageResource(R.drawable.f5)
                text.text = "咲きました！"
            }
        }
    }

    fun onReset() {
        stage = 0
        image.setImageResource(R.drawable.f0)
        text.text = "水をあげましょう"
    }
}