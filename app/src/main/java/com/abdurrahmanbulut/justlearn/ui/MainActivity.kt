package com.abdurrahmanbulut.justlearn.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.staticCompositionLocalOf
import com.abdurrahmanbulut.justlearn.navigator.Navigator
import com.abdurrahmanbulut.justlearn.navigator.screen.AppNavigation
import com.abdurrahmanbulut.justlearn.ui.theme.JustLearnTheme

val LocalNavigator = staticCompositionLocalOf<Navigator> { error("No Navigator provided") }


class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            JustLearnTheme {
                Surface {
                    AppNavigation()
                }
            }
        }
    }

}
