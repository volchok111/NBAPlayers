package com.volchok.nbaplayers.library.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.volchok.nbaplayers.library.ui.NbaColors.chrome900
import com.volchok.nbaplayers.library.ui.NbaColors.pink
import com.volchok.nbaplayers.library.ui.NbaColors.white

@Composable
fun NbaAlertDialog(
    title: String,
    onDismiss: () -> Unit,
    positiveButtonText: String,
    modifier: Modifier = Modifier,
    onPositiveButtonClick: () -> Unit = onDismiss,
    message: String? = null,
    negativeButtonText: String? = null,
    onNegativeButtonClick: (() -> Unit) = onDismiss,
    neutralButtonText: String? = null,
    onNeutralButtonClick: (() -> Unit) = onDismiss,
    dialogProperties: DialogProperties = DialogProperties()
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = dialogProperties,

    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(NbaDimensions.sizeXXS),
            color = white,
            contentColor = chrome900
        ) {
            Column(
                modifier = Modifier.padding(NbaDimensions.sizeXS)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(NbaDimensions.sizeS)
                )
                if (!message.isNullOrEmpty()) {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(NbaDimensions.sizeS)
                    )
                }
                Spacer(modifier = Modifier.height(NbaDimensions.sizeXS))
                Row {
                    neutralButtonText?.let {
                        NbaActionButton(
                            text = it,
                            onClick = onNeutralButtonClick
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    negativeButtonText?.let {
                        NbaActionButton(
                            text = it,
                            onClick = onNegativeButtonClick
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = NbaDimensions.sizeXXS),
                        contentAlignment = BottomEnd
                    ) {
                        NbaText(
                            text = positiveButtonText,
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier
                                .clickable { onPositiveButtonClick() }
                                .padding(end = NbaDimensions.sizeXS),
                            color = pink,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(NbaDimensions.sizeXXS))
            }
        }
    }
}

@Composable
fun NbaLoadingDialog(
    title: String,
    modifier: Modifier = Modifier,
    text: String? = null,
) {
    val isLoading by remember { mutableStateOf(true) }
   // val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(com.volchok.rocketapp.R.raw.rocket))
//    val progress by animateLottieCompositionAsState(
//        composition = composition,
//        isPlaying = isLoading,
//        iterations = 1000
//    )
    Surface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(NbaDimensions.sizeS),
        color = white,
        contentColor = chrome900
    ) {
        Column(
            modifier = Modifier.padding(NbaDimensions.sizeM)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h2
            )
            if (!text.isNullOrEmpty()) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = NbaDimensions.sizeL)
                )
            }
            Spacer(modifier = Modifier.height(NbaDimensions.sizeM))
//            LottieAnimation(
//                composition = composition,
//                progress = { progress })
            Spacer(modifier = Modifier.height(NbaDimensions.sizeXXS))
        }
    }
}