package com.example.flower_demo.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.example.flower_demo.ui.component.FlowerImage
import com.example.flower_demo.ui.component.WaterButton

@Composable
fun FlowerScreen() {
    var stage by remember { mutableStateOf(0) }

    Column {
        FlowerImage(stage)

        WaterButton {
            stage++
        }
    }
}