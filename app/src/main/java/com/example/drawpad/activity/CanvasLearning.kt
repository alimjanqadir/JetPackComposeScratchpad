package com.example.drawpad.activity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Circle() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        withTransform({
            translate(left = size.width / 5)
            rotate(degrees = 45F)
        }) {
            drawRect(
                Color.Black,
                topLeft = Offset(size.width / 2 - (200.dp.toPx() / 2),
                    size.height / 2 - (100.dp.toPx() / 2)),
                size = Size(
                    width = 200.dp.toPx(),
                    height = 100.dp.toPx()
                )
            )
        }
    }
}

@Preview()
@Composable
fun CirclePreview() {
    MaterialTheme {
        Circle()
    }
}