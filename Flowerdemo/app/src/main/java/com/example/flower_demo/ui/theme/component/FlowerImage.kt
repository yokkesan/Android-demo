package com.example.flower_demo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.flower_demo.R

@Composable
fun FlowerImage(stage: Int) {

    val images = listOf(
        R.drawable.f0,
        R.drawable.f1,
        R.drawable.f2,
        R.drawable.f3,
        R.drawable.f4,
        R.drawable.f5
    )

    Image(
        painter = painterResource(id = images[stage]),
        contentDescription = "flower"
    )
}