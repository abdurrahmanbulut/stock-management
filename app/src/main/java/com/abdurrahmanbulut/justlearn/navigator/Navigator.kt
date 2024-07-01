package com.abdurrahmanbulut.justlearn.navigator

import androidx.navigation.NavHostController

class Navigator(private val navController: NavHostController) {
    fun navigateTo(route: String) {
        navController.navigate(route)
    }

    fun pop() {
        navController.popBackStack()
    }
}