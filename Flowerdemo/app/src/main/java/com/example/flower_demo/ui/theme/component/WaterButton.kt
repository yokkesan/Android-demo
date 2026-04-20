package com.example.flower_demo.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun WaterButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("水をあげる")
    }
}