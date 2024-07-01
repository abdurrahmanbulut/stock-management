package com.abdurrahmanbulut.justlearn.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.justlearn.R
import com.abdurrahmanbulut.justlearn.navigator.screen.Screen
import com.abdurrahmanbulut.justlearn.ui.LocalNavigator
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun SplashScreen() {
    val navigator = LocalNavigator.current
    val viewModel: SplashViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        delay(3000)
        navigator.navigateTo(Screen.Home.route)
    }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    LottieAnimation(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 60.dp),
        composition = composition,
    )
}
