package com.abdurrahmanbulut.justlearn.navigator.screen

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")

    data object Home : Screen("home")
}
