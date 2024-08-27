package com.example.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import com.tritus.transparentvideo.video.transparent.TransparentVideo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayout() {
                data class Info(
                    val ref: ConstrainedLayoutReference,
                    val topMargin: Dp,
                    val startMargin: Dp,
                )
                val (b1, b2, b3, b4, b5, b6) = remember { createRefs() }
                val boxesInfo = remember {
                    listOf(
                        Info(b1, 0.dp, 0.dp),
                        Info(b2, 50.dp, 30.dp),
                        Info(b3, 100.dp, 60.dp),
                        Info(b4, 150.dp, 90.dp),
                        Info(b5, 175.dp, 105.dp),
                        Info(b6, 300.dp, 150.dp),
                    )
                }
                boxesInfo.forEach {
                    Box(modifier = Modifier
                        .constrainAs(it.ref) {
                            top.linkTo(parent.top, margin = it.topMargin)
                            start.linkTo(parent.start, margin = it.startMargin)
                        }
                        .fillMaxSize(0.5f)) {
                        TransparentVideo(source = R.raw.thunder_loader)
                    }
                }
            }
        }
    }
}
