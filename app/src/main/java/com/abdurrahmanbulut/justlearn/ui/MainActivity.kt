package com.abdurrahmanbulut.justlearn.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.staticCompositionLocalOf
import com.abdurrahmanbulut.justlearn.navigator.screen.AppNavigation
import com.abdurrahmanbulut.justlearn.ui.theme.JustLearnTheme
import com.abdurrahmanbulut.sherlock.navigation.Navigator

val LocalNavigator = staticCompositionLocalOf<Navigator> { error("No Navigator provided") }

class MainActivity : ComponentActivity() {
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
