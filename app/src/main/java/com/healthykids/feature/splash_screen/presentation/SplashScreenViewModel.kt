package com.healthykids.feature.splash_screen.presentation

import androidx.lifecycle.viewModelScope
import com.healthykids.core.base.BaseCoroutineDispatchers
import com.healthykids.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<SplashScreenEvent>(dispatchers) {

    override fun loadInitialData() {
        viewModelScope.launch {
            delay(2000)
            navigateToNextScreen()
        }
    }

    fun navigateToNextScreen() {
        viewModelScope.launch {
            pushSingle(SplashScreenEvent.NavigateToNextScreen)
        }
    }

}