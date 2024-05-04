package com.healthykids.feature.result.presentation

import androidx.lifecycle.SavedStateHandle
import com.healthykids.core.base.BaseCoroutineDispatchers
import com.healthykids.core.base.BaseViewModel
import com.healthykids.feature.calculate_calories.domain.WeightType
import com.healthykids.utils.Constants.Intent.CALORIES
import com.healthykids.utils.Constants.Intent.WEIGHT_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    dispatchers: BaseCoroutineDispatchers
) : BaseViewModel<ResultEvent>(dispatchers) {

    val bmi = savedStateHandle.get<WeightType>(WEIGHT_TYPE)?.getName() ?: ""
    val calories = savedStateHandle.get<Int>(CALORIES) ?: 0

    fun navigateToMeals() {
        pushSingle(ResultEvent.NavigateToMeals(calories))
    }

    fun navigateToInstructions() {
        pushSingle(ResultEvent.NavigateToInstructions)
    }

    fun cancel() {
        pushSingle(ResultEvent.Cancel)
    }

}