package com.abdurrahmanbulut.justlearn.navigator.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abdurrahmanbulut.justlearn.ui.main.home.HomeScreen
import com.abdurrahmanbulut.justlearn.ui.splash.SplashScreen

fun NavGraphBuilder.navGraph(){
    composable(Screen.Splash.route) { SplashScreen() }
    composable(Screen.Home.route) { HomeScreen() }
}