package com.healthykids.feature.result.presentation

sealed class ResultEvent {
    data class NavigateToMeals(val calories: Int) : ResultEvent()
    data object NavigateToInstructions : ResultEvent()
    data object Cancel : ResultEvent()
}