package com.abdurrahmanbulut.stockManagement.ui.main

import androidx.lifecycle.ViewModel
import com.abdurrahmanbulut.sherlock.navigation.Navigator
import com.abdurrahmanbulut.stockManagement.ui.utils.createEvent
import com.abdurrahmanbulut.stockManagement.ui.utils.triggered

class MainScreenVM : ViewModel() {
    val onFirst = createEvent()
    val onSecond = createEvent()
    lateinit var navigator: Navigator

    fun onClickFirst() {
        onFirst.value = triggered
    }

    fun onClickSecond() {
        onSecond.value = triggered
    }
}
