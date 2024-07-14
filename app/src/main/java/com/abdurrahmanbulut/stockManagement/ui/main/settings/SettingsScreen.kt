package com.abdurrahmanbulut.stockManagement.ui.main.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.stockManagement.navigator.LocalInsets
import com.abdurrahmanbulut.stockManagement.ui.main.MainScreenVM
import com.abdurrahmanbulut.stockManagement.ui.navigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(parentViewModel: MainScreenVM) {
    val viewModel: SettingsScreenVM = koinViewModel()
    val navigator = navigator()
    val insets = LocalInsets.current
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = insets.statusBarHeight)
                .clickable { navigator.pop() },
    ) {
        Text(
            text = viewModel.text,
            modifier = Modifier.padding(bottom = 20.dp),
        )
    }
}
