package com.abdurrahmanbulut.stockManagement.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.stockManagement.navigator.LocalInsets
import com.abdurrahmanbulut.stockManagement.ui.main.MainScreenVM
import com.abdurrahmanbulut.stockManagement.ui.navigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(parentViewModel: MainScreenVM) {
    val viewModel: HomeScreenVM = koinViewModel()
    val navigator = navigator()
    val insets = LocalInsets.current
    Box(
        modifier =
            Modifier.fillMaxSize()
                .padding(top = insets.statusBarHeight).background(Color.Gray),
    ) {
        Text(
            text = viewModel.stock.value.toString(),
            modifier = Modifier.padding(bottom = 20.dp),
        )
    }
}
