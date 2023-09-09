package com.example.jetpack_compose_scratchpad

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage


@Preview
@Composable
fun CoilTest() {
    AsyncImage(
        model = "https://avatars.githubusercontent.com/u/52722434?s=200&v=4",
        contentDescription = null
    )
}
