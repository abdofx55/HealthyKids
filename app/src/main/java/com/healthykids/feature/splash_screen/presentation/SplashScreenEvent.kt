package com.healthykids.feature.splash_screen.presentation

sealed class SplashScreenEvent {
    data object NavigateToNextScreen : SplashScreenEvent()
}