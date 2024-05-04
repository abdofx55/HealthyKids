package com.healthykids.feature.success.presentation

sealed class SuccessEvent {
    data object Done : SuccessEvent()
}