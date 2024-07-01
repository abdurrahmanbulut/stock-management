package com.abdurrahmanbulut.justlearn.navigator.screen

import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdurrahmanbulut.justlearn.navigator.Navigator
import com.abdurrahmanbulut.justlearn.ui.InsetsViewModel
import com.abdurrahmanbulut.justlearn.ui.LocalNavigator
import com.abdurrahmanbulut.justlearn.ui.main.home.HomeScreen
import com.abdurrahmanbulut.justlearn.ui.splash.SplashScreen
import org.koin.androidx.compose.koinViewModel

val LocalInsets =
    compositionLocalOf<InsetsViewModel> { error("No InsetsViewModel provided") }


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navigator = remember { Navigator(navController) }
    val systemBarsPadding = WindowInsets.systemBars.asPaddingValues()
    val insets: InsetsViewModel = koinViewModel()

    insets.statusBarHeight = systemBarsPadding.calculateTopPadding()
    insets.navigationBarHeight = systemBarsPadding.calculateBottomPadding()

    CompositionLocalProvider(
        LocalNavigator provides navigator,
        LocalInsets provides insets
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            enterTransition = Navigation.enterTransition,
            exitTransition = Navigation.exitTransition,
            popEnterTransition = Navigation.popEnterTransition,
            popExitTransition = Navigation.popExitTransition
        ) {
            navGraph()
        }
    }

}


private data object Navigation {
    var enterTransition: EnterTransitionCallback =
        { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) }
    var exitTransition: ExitTransitionCallback =
        { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) }
    var popEnterTransition: EnterTransitionCallback =
        { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }
    var popExitTransition: ExitTransitionCallback =
        { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }
}

typealias EnterTransitionCallback = AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition
typealias ExitTransitionCallback = AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition
