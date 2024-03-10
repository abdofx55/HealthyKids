package com.healthykids.feature.calculate_calories.presentation

import com.healthykids.feature.calculate_calories.domain.ActivityType
import com.healthykids.feature.calculate_calories.domain.Age
import com.healthykids.feature.calculate_calories.domain.SexType
import com.healthykids.feature.calculate_calories.domain.WeightType

sealed class CaloriesEvent {
    data class SexTypeFetched(val data: MutableList<SexType>): CaloriesEvent()
    data class AgeFetched(val data: MutableList<Age>): CaloriesEvent()
    data class ActivityTypeFetched(val data: MutableList<ActivityType>): CaloriesEvent()
    data object ShowResultForNormalWeight: CaloriesEvent()
    data class ShowResultForOverWeight(val calories: Int): CaloriesEvent()
    data object CalculateCalories : CaloriesEvent()
}