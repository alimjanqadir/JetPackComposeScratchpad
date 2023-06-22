package com.example.jetpack_compose_scratchpad.activity

import android.media.Image
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.jetpack_compose_scratchpad.R

@Composable
fun ExpandingWidget() {
    Card {
        var expanded by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .clickable { expanded = !expanded },
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(R.drawable.icon), "logo")
            AnimatedVisibility(visible = !expanded) {
                Text(
                    text = "Icon",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    ExpandingWidget()
}