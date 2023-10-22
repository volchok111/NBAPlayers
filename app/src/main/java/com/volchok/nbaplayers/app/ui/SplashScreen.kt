package com.volchok.nbaplayers.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.volchok.nbaplayers.R
import com.volchok.nbaplayers.app.presentation.SplashViewModel
import com.volchok.nbaplayers.library.ui.NbaColors
import com.volchok.nbaplayers.library.ui.NbaDimensions
import org.koin.androidx.compose.getViewModel

@Composable
fun SplashScreen() {
    val viewModel = getViewModel<SplashViewModel>()
    val state = viewModel.states.collectAsState()

    SplashScreenImpl(
        state = state.value
    )
}

@Composable
private fun SplashScreenImpl(
    modifier: Modifier = Modifier,
    state: SplashViewModel.State
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.basketball))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = state.loading,
        iterations = 1000
    )
    Surface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(NbaDimensions.sizeS),
        color = NbaColors.white,
        contentColor = NbaColors.chrome900
    ) {
        Column(
            modifier = Modifier.padding(NbaDimensions.sizeM)
        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress })
        }
    }
}