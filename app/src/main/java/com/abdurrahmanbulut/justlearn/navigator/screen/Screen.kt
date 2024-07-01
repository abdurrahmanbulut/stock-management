package com.abdurrahmanbulut.justlearn.navigator.screen

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Home : Screen("home")
    data object Study : Screen("study")
    data object Quiz : Screen("quiz")
    data object Management : Screen("management")
    data object Statistics : Screen("statistics")
    data object Settings : Screen("settings")
}