package com.volchok.nbaplayers.library.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.volchok.nbaplayers.R

@Composable
fun NbaTopBar(
    title: String,
    onBackClick: (() -> Unit)? = null,
) {
    TopAppBar(
        backgroundColor = NbaColors.background,
        title = {
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                NbaText(
                    text = title,
                    style = MaterialTheme.typography.h5,
                    color = NbaColors.black,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = onBackClick?.let {
            {
                IconButton(onClick = it) {
                    NbaIcon(
                        icon = R.drawable.arrow_back,
                        contentDescription = "Back",
                    )
                }
            }
        }
    )
}